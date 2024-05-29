package com.example.Chain.of.Responsibility.Pattern;

import com.example.Chain.of.Responsibility.Pattern.handler.Handler;
import com.example.Chain.of.Responsibility.Pattern.handler.PersistenceHandler;
import com.example.Chain.of.Responsibility.Pattern.handler.ValidationHandler;
import com.example.Chain.of.Responsibility.Pattern.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChainOfResponsibilityPatternApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(ChainOfResponsibilityPatternApplication.class, args);
    }

    @Bean
    public Handler handler() {
        Handler validationHandler = new ValidationHandler();
        Handler persistenceHandler = new PersistenceHandler(userMapper);

        validationHandler.setNext(persistenceHandler);

        return validationHandler;
    }

}
