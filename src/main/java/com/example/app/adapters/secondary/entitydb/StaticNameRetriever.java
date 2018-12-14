package com.example.app.adapters.secondary.entitydb;

import com.example.app.domain.model.entities.NameRetriever;
import org.springframework.stereotype.Component;

@Component
public class StaticNameRetriever implements NameRetriever {

    @Override
    public String retrieveName(String id) {
        return "Entity";
    }

}
