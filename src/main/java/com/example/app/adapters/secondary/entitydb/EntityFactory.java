package com.example.app.adapters.secondary.entitydb;

import com.example.app.adapters.primary.restapi.Harmless;
import com.example.app.domain.model.entities.EntityRepository;
import com.example.app.domain.model.entities.NameRetriever;
import com.example.app.domain.model.entities.Entity;
import org.springframework.stereotype.Repository;

@Repository
public class EntityFactory implements EntityRepository {

    private NameRetriever nameRetriever;
    private Harmless harmless;

    public EntityFactory(NameRetriever nameRetriever, Harmless harmless) {
        this.nameRetriever = nameRetriever;
        this.harmless = harmless;
    }

    @Override
    public Entity getRandomEntity() {
        return new Entity(nameRetriever);
    }
}
