package com.dds.lectordenotas;

import com.dds.lectordenotas.rest.NotitasAPIClient;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class RestClientTest {
    @Test
    public void clientWithTokenShouldYieldAClientWithAValidHeaderValue() {
        NotitasAPIClient client = NotitasAPIClient.withToken("1234");

        Assert.assertEquals("Bearer 1234", client.getAuthInfo());
    }
    
}
