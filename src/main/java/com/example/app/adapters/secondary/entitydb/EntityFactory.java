package com.example.app.adapters.secondary.entitydb;

import com.example.app.domain.model.entities.Entity;
import com.example.app.domain.model.entities.EntityRepository;
import com.example.app.domain.model.entities.NameRetriever;
import org.springframework.stereotype.Repository;

@Repository
public class EntityFactory implements EntityRepository {

    private NameRetriever nameRetriever;

    public EntityFactory(NameRetriever nameRetriever) {
        this.nameRetriever = nameRetriever;
    }

    @Override
    public Entity getRandomEntity() {
        return new Entity(nameRetriever);
    }
}
