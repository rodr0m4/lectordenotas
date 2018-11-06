package com.dds.lectordenotas.model.repositories;

import com.dds.lectordenotas.rest.NotitasAPIClient;

public class Session {

    private static final Session INSTANCE = new Session();

    private NotitasAPIClient client;

    private Session() {}

    public static Session session() {
        return INSTANCE;
    }

    public NotitasAPIClient getClient() {
        return client;
    }

    public void setClient(NotitasAPIClient client) {
        this.client = client;
    }
}
