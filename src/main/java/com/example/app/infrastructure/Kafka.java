package com.example.app.infrastructure;

import com.example.app.domain.services.DomainService;
import org.springframework.stereotype.Component;

@Component
public class Kafka {
    private DomainService ds;

    public Kafka(DomainService ds) {
        this.ds = ds;
    }
}
