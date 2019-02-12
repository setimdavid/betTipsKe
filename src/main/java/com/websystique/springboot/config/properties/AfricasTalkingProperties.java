package com.websystique.springboot.config.properties;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by KennethKZMMuhia
 * Project: zeus
 * Package: org.app.properties.config.integ.ke.properties
 * Generated on: 13-Apr-17, 21:16
 */
@Data
@Configuration
public class AfricasTalkingProperties {
    @Value("${org.app.properties.config.africastalking.integ.username.data}")
    private String integUsernameData;
    @Value("${org.app.properties.config.africastalking.integ.username.keyword}")
    private String integUsernameKeyword;
    @Value("${org.app.properties.config.africastalking.integ.enviroment}")
    private String integEnviroment;
    @Value("${org.app.properties.config.africastalking.integ.sender}")
    private String integSender;
    @Value("${org.app.properties.config.africastalking.response.code.http.ok}")
    private int responseCodeHttpOk;
    @Value("${org.app.properties.config.africastalking.response.code.http.created}")
    private int responseCodeHttpCreated;
    @Value("${org.app.properties.config.africastalking.integ.debug}")
    private boolean integDebug;
    @Value("${org.app.properties.config.africastalking.prod.api.host}")
    private String prodApiHost;
    @Value("${org.app.properties.config.africastalking.sandbox.api.host}")
    private String sandboxApiHost;
    @Value("${org.app.properties.config.africastalking.prod.payments.host}")
    private String prodPaymentsHost;
    @Value("${org.app.properties.config.africastalking.sandbox.payments.host}")
    private String sandboxPaymentsHost;
    @Value("${org.app.properties.config.africastalking.prod.voice.host}")
    private String prodVoiceHost;
    @Value("${org.app.properties.config.africastalking.sandbox.voice.host}")
    private String sandboxVoiceHost;
    @Value("${org.app.properties.config.africastalking.sms.url}")
    private String smsUrl;
    @Value("${org.app.properties.config.africastalking.voice.url}")
    private String voiceUrl;
    @Value("${org.app.properties.config.africastalking.subscription.url}")
    private String subscriptionUrl;
    @Value("${org.app.properties.config.africastalking.user.data.url}")
    private String userDataUrl;
    @Value("${org.app.properties.config.africastalking.airtime.url}")
    private String airtimeUrl;
    @Value("${org.app.properties.config.africastalking.payment.checkout.url}")
    private String paymentCheckoutUrl;
    @Value("${org.app.properties.config.africastalking.mobile.payment.b2b.url}")
    private String mobilePaymentB2bUrl;
    @Value("${org.app.properties.config.africastalking.mobile.payment.b2c.url}")
    private String mobilePaymentB2cUrl;
    @Value("${org.app.properties.config.africastalking.integ.phonenumber.keyword}")
    private String integPhonenumberKeyword;
    @Value("${org.app.properties.config.africastalking.integ.phonenumber.data}")
    private String integPhonenumberData;
    @Value("${org.app.properties.config.africastalking.integ.keyword.keyword}")
    private String integKeywordKeyword;
    @Value("${org.app.properties.config.africastalking.integ.keyword.data}")
    private String integKeywordData;
    @Value("${org.app.properties.config.africastalking.integ.shortcode.keyword}")
    private String integShortcodeKeyword;
    @Value("${org.app.properties.config.africastalking.integ.shortcode.data}")
    private String integShortcodeData;
    @Value("${org.app.properties.config.africastalking.integ.to.keyword}")
    private String integToKeyword;
    @Value("${org.app.properties.config.africastalking.integ.to.data}")
    private String integToData;
    @Value("${org.app.properties.config.africastalking.integ.from.keyword}")
    private String integFromKeyword;
    @Value("${org.app.properties.config.africastalking.integ.from.data}")
    private String integFromData;
    @Value("${org.app.properties.config.africastalking.integ.phone.numbers.keyword}")
    private String integPhoneNumbersKeyword;
    @Value("${org.app.properties.config.africastalking.integ.phone.numbers.data}")
    private String integPhoneNumbersData;
    @Value("${org.app.properties.config.africastalking.integ.currency.code.keyword}")
    private String integCurrencyCodeKeyword;
    @Value("${org.app.properties.config.africastalking.integ.currency.code.data}")
    private String integCurrencyCodeData;
    @Value("${org.app.properties.config.africastalking.integ.amount.keyword}")
    private String integAmountKeyword;
    @Value("${org.app.properties.config.africastalking.integ.amount.data}")
    private String integAmountData;
    @Value("${org.app.properties.config.africastalking.integ.metadata.keyword}")
    private String integMetadataKeyword;
    @Value("${org.app.properties.config.africastalking.integ.metadata.data}")
    private String integMetadataData;
    @Value("${org.app.properties.config.africastalking.url.header.accept.keyword}")
    private String urlHeaderAcceptKeyword;
    @Value("${org.app.properties.config.africastalking.url.header.accept.data}")
    private String urlHeaderAcceptData;
    @Value("${org.app.properties.config.africastalking.url.header.api.keyword}")
    private String urlHeaderApiKeyword;
    @Value("${org.app.properties.config.africastalking.url.header.api.data}")
    private String urlHeaderApiData;
    @Value("${org.app.properties.config.africastalking.sms.message.data.keyword}")
    private String smsMessageDataKeyword;
    @Value("${org.app.properties.config.africastalking.integ.response.recipients.keyword}")
    private String integResponseRecipientsKeyword;
    @Value("${org.app.properties.config.africastalking.integ.response.message.keyword}")
    private String integResponseMessageKeyword;
    @Value("${org.app.properties.config.africastalking.integ.sms.message.keyword}")
    private String integSmsMessageKeyword;
    @Value("${org.app.properties.config.africastalking.integ.http.method.post}")
    private String integHttpMethodPost;
    @Value("${org.app.properties.config.africastalking.integ.http.method.get}")
    private String integHttpMethodGet;
    @Value("${org.app.properties.config.africastalking.integ.url.encode.encoding}")
    private String integUrlEncodeEncoding;
    @Value("${org.app.properties.config.africastalking.sms.send.success.keyword}")
    private String smsSendSuccessKeyword;

}