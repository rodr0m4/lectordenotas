package com.dds.lectordenotas;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.rest.Client;

public class AsignacionTest {

    @Test
    public void traeAsignaciones() {
    	Client client = Client.withToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIx"
    			+ "MTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
    	
        List<Asignacion> asignaciones = client.assignments();

        assertTrue(!asignaciones.isEmpty());
    }
}
