package com.example.app.application.services;

import com.example.app.domain.model.entities.Entity;
import com.example.app.domain.model.entities.EntityRepository;
import com.example.app.domain.services.DomainService;
import org.springframework.stereotype.Component;

@Component
public class UseCase {

    private DomainService service;
    private EntityRepository repo;

    public UseCase(DomainService service, EntityRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    public String myThing() {
        Entity entity = repo.getRandomEntity();
        return service.complexOperation(entity);
    }

}
