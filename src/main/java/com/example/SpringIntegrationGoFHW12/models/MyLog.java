package com.example.SpringIntegrationGoFHW12.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Интерфейс для логирования выполняемых задач
 * */
@Component
public interface MyLog {
    /**
     * Метод записи выполняемых задач.
     * В качестве аргумента принимает заисываемое сообщение
     * */
    void writeLog(String logMessage);
}
