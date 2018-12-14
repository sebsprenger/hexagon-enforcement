package com.example.app.domain.services;

import com.example.app.domain.model.entities.Entity;

public class DomainService {

    public String complexOperation(Entity input) {
        return "Look, it's an " + input;
    }

}
