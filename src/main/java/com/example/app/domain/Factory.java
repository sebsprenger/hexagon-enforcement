package com.example.app.domain;

import com.example.app.domain.services.DomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Factory {

    @Bean
    public DomainService domainService() {
        return new DomainService();
    }

}
