package com.dds.lectordenotas.model.repositories;

import com.dds.lectordenotas.rest.Client;

public class Session {

    private static final Session INSTANCE = new Session();

    private Client client;

    private Session() {}

    public static Session session() {
        return INSTANCE;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
