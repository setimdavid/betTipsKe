package com.websystique.springboot.controller;

import com.websystique.springboot.dto.ApiResponse;
import com.websystique.springboot.integ.AfricasTalkingGateway;
import com.websystique.springboot.model.KopoRequest;
import com.websystique.springboot.repo.KopoRequestRepository;
import com.websystique.springboot.model.SubscriberDetails;
import com.websystique.springboot.repo.SubscriberDetailsRepository;
import com.websystique.springboot.utilities.IpcUtilities;
import lombok.extern.java.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

@Log
@RestController
@RequestMapping("/simplophone/api")
public class KopoKopoContoller {

    private final KopoRequestRepository kopoRequestRepository;
    private final SubscriberDetailsRepository subscriberDetailsRepository;
    private final AfricasTalkingGateway africasTalkingGateway;
    private final IpcUtilities ipcUtilities;

    public KopoKopoContoller(KopoRequestRepository kopoRequestRepository,SubscriberDetailsRepository subscriberDetailsRepository,
                             AfricasTalkingGateway africasTalkingGateway, IpcUtilities ipcUtilities) {
        this.kopoRequestRepository = kopoRequestRepository;
        this.subscriberDetailsRepository = subscriberDetailsRepository;
        this.africasTalkingGateway = africasTalkingGateway;
        this.ipcUtilities = ipcUtilities;
    }

    @RequestMapping(value = "/kopokopo/request/v1", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponse> createUserDetails(@RequestBody String responseResult)
    {

        log.log(Level.INFO, "KopoKopo Request Payload = '{}'", responseResult);
        HttpStatus httpStatus;
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setStatus("01");
        apiResponse.setDescription("Activated");
        apiResponse.setSubscriber_message("The Message");

        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(apiResponse, httpStatus);
    }

    @RequestMapping(value = "/kopokopo/request", method = RequestMethod.POST)
    @ResponseBody
    public String processKopokopoRequest(@RequestBody String responseResult) {
        log.log(Level.INFO, "KopoKopo Request Payload = '{}'", responseResult);
        KopoRequest request = new KopoRequest();
        try {
            JSONObject reponseObject = new JSONObject(responseResult);
            request.setServiceName(reponseObject.get("service_name").toString());
            request.setBusinessNumber(reponseObject.get("business_number").toString());
            request.setTransactionReference(reponseObject.get("transaction_reference").toString());
            request.setInternalTransactionId(Double.valueOf(reponseObject.get("internal_transaction_id").toString()));
            request.setTransactionTimestamp(reponseObject.get("transaction_timestamp").toString());
            request.setTransactionType(reponseObject.get("transaction_type").toString());
            request.setAccountNumber(reponseObject.get("account_number").toString());
            request.setSenderPhone(reponseObject.get("sender_phone").toString().replace("+",""));
            request.setFirstName(reponseObject.get("first_name").toString());
            request.setMiddleName(reponseObject.get("middle_name").toString());
            request.setLastName(reponseObject.get("last_name").toString());
            request.setAmount(Double.valueOf(reponseObject.get("amount").toString().replace(",","")));
            request.setCurrency(reponseObject.get("currency").toString());
            request.setKopoSignature(reponseObject.get("signature").toString());
        }catch(Exception ex){
            log.log(Level.INFO, ex.getMessage(), ex);
            try {
                africasTalkingGateway.sendMessage("254722680308",ex.getMessage(), "");
            } catch (Exception e) {
                log.log(Level.INFO, ex.getMessage(), ex);
            }
        }
        JSONObject response = new JSONObject();
        String message = processRequest(request);
        try {
            response.put("status", "01");
            response.put("description", "Accepted");
            response.put("subscriber_message", message);
        } catch (JSONException e) {
            log.log(Level.INFO, e.getMessage(), e);
        }
        request.setResponseStatus("01");
        request.setResponseDesciption("Accepted");
        request.setResponseSubscriberMessage(message);
        kopoRequestRepository.save(request);
        return response.toString();
    }

    String processRequest(KopoRequest request){
        LocalDate todayDate = LocalDate.now();
        LocalDate nextJackPotLocalDate = todayDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        Date nextJackPotDate = Date.from(nextJackPotLocalDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        AtomicReference<Date> dailyEndDate = new AtomicReference<>(new Date());

        Integer dailyStatus = 0;
        Integer jackpotStatus = 0;
        Integer dailyEndDateDays = 0;

        switch (request.getAmount().intValue()){
            case 50: // 1 day subscription
                dailyStatus = 1;
                dailyEndDate.set(Date.from(todayDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                break;
            case 200: // Jackpot Only
                jackpotStatus = 1;
                break;
            case 250: // Weekend plus Jackpot
                dailyStatus = 1;
                jackpotStatus = 1;
                dailyEndDateDays = 1;
                LocalDate changeDay = LocalDate.now().plusDays(dailyEndDateDays);
                dailyEndDate.set(Date.from(changeDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                break;
            case 299: // 1 week subscription
                dailyStatus = 1;
                dailyEndDateDays = 6;
                LocalDate changeDayTwo = LocalDate.now().plusDays(dailyEndDateDays);
                dailyEndDate.set(Date.from(changeDayTwo.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                break;
            case 400: //1 week plus Jackpot
                dailyStatus = 1;
                dailyEndDateDays = 6;
                jackpotStatus = 1;
                LocalDate changeDayThree = LocalDate.now().plusDays(dailyEndDateDays);
                dailyEndDate.set(Date.from(changeDayThree.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                break;
            default:
                if (request.getAmount().intValue() > 400){
                    dailyStatus = 1;
                    dailyEndDateDays = 6;
                    jackpotStatus = 1;
                    LocalDate changeDayFour = LocalDate.now().plusDays(dailyEndDateDays);
                    dailyEndDate.set(Date.from(changeDayFour.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                }else if (request.getAmount().intValue() > 299){
                    dailyStatus = 1;
                    dailyEndDateDays = 6;
                    LocalDate changeDayFive = LocalDate.now().plusDays(dailyEndDateDays);
                    dailyEndDate.set(Date.from(changeDayFive.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                }else if (request.getAmount().intValue() > 250){
                    dailyStatus = 1;
                    jackpotStatus = 1;
                    dailyEndDateDays = 1;
                    LocalDate changeDaySix = LocalDate.now().plusDays(dailyEndDateDays);
                    dailyEndDate.set(Date.from(changeDaySix.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                }else if (request.getAmount().intValue() > 200){
                    jackpotStatus = 1;
                }else if (request.getAmount().intValue() > 50){
                    dailyStatus = 1;
                    dailyEndDate.set(Date.from(todayDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                }
                break;
        }

        Integer finalJackpotStatus = jackpotStatus;
        Integer finalDailyStatus = dailyStatus;
        String password = ipcUtilities.generatePassword();
        AtomicReference<Integer> presentStatus = new AtomicReference<>(0);


        java.sql.Date nextJackPotDateSQL = new java.sql.Date(nextJackPotDate.getTime());
        java.sql.Date dailyEndDateSQL = new java.sql.Date(dailyEndDate.get().getTime());
        subscriberDetailsRepository.findSubscriberDetailsByPhoneNumber(request.getSenderPhone())
            .ifPresent(sub -> {
                presentStatus.set(1);
                if (finalJackpotStatus == 1){
                    sub.setJackpotStatus(1);
                    sub.setJackpotEndDate(nextJackPotDateSQL);
                }
                if (finalDailyStatus == 1){
                    sub.setDailyEndDate(dailyEndDateSQL);
                    sub.setDailyStatus(1);
                }
                sub.setPassword(password);
                sub.setModifiedDate(Timestamp.from(Instant.now()));
                subscriberDetailsRepository.save(sub);
            }
        );

        if (presentStatus.get() == 0){
            SubscriberDetails subDetails = new SubscriberDetails();
            subDetails.setFirstName(request.getFirstName());
            subDetails.setMiddleName(request.getMiddleName());
            subDetails.setLastName(request.getLastName());
            subDetails.setPhoneNumber(request.getSenderPhone());
            subDetails.setCreatedDate(Timestamp.from(Instant.now()));
            subDetails.setPassword(password);
            if (finalJackpotStatus == 1){
                subDetails.setJackpotStatus(1);
                subDetails.setJackpotEndDate(nextJackPotDateSQL);
            }
            if (finalDailyStatus == 1){
                subDetails.setDailyEndDate(dailyEndDateSQL);
                subDetails.setDailyStatus(1);
            }
            subscriberDetailsRepository.save(subDetails);
        }

        String message = "Your payment of Ksh " + request.getAmount().toString() + " has been received.Username : " + request.getSenderPhone() + "" +
                ",Password : " + password + ". Get the odds here : www.surebetske.co.ke";
        return message;
    }
}
