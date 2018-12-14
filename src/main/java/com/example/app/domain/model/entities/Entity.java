package com.example.app.domain.model.entities;

public class Entity {

    private final String ID = "SOME_ENTITIY";
    private NameRetriever retriever;

    public Entity(NameRetriever retriever) {
        this.retriever = retriever;
    }

    public String toString() {
        return retriever.retrieveName(ID);
    }

}
