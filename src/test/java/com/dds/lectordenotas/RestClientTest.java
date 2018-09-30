package com.dds.lectordenotas;

import com.dds.lectordenotas.rest.Client;
import org.junit.Assert;
import org.junit.Test;

public class RestClientTest {
    @Test
    public void clientWithTokenShouldYieldAClientWithAValidHeaderValue() {
        Client client = Client.withToken("1234");

        Assert.assertEquals("Bearer 1234", client.getAuthInfo());
    }
}
