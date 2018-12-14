package com.example.app.application.services;

import com.example.app.adapters.secondary.entitydb.StaticNameRetriever;
import com.example.app.domain.model.entities.EntityRepository;
import com.example.app.domain.model.entities.Entity;
import com.example.app.domain.services.DomainService;
import org.springframework.stereotype.Component;

@Component
public class UseCase {

    private DomainService service;
    private EntityRepository repo;
    private StaticNameRetriever retriever;


  public UseCase(DomainService service, EntityRepository repo, StaticNameRetriever retriever) {
        this.service = service;
        this.repo = repo;
        this.retriever = retriever;
    }

    public String myThing() {
        Entity entity = repo.getRandomEntity();
        retriever.retrieveName(null);
        return service.complexOperation(entity);
    }

}
