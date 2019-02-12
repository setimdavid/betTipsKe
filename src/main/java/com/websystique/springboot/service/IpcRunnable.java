package com.websystique.springboot.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

@Component
@Log
public class IpcRunnable {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Integer SMSCAMPAIGNSCHEDULER = 60000;

    @Value("${org.app.scheduler.check.campaing.sms}")
    private String smsCampaing;
}
