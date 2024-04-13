package com.example.SpringIntegrationGoFHW12.models;

import com.example.SpringIntegrationGoFHW12.services.FileGateway;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FileLog implements MyLog{
    private final FileGateway fileGateway;
    @Override
    public void writeLog(String logMessage) {
        fileGateway.writeToFile("LogFile.txt", logMessage);
    }
}
