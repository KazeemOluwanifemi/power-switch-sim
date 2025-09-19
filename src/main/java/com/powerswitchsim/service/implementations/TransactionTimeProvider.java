package com.powerswitchsim.service.implementations;

import com.powerswitchsim.service.TimeStampProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionTimeProvider implements TimeStampProvider {
    @Override
    public String getCurrentTimeStamp() {
        LocalDateTime timeStamp = LocalDateTime.now();
        return timeStamp.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a"));
    }
}
