package com.example.SpringIntegrationGoFHW12.models;

import org.springframework.stereotype.Component;

@Component
public class ConsoleLog implements MyLog {
    @Override
    public void writeLog(String logMessage) {
        System.out.println(logMessage);
    }
}
