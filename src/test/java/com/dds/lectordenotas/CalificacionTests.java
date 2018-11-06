package com.dds.lectordenotas;

import org.junit.Before;

import com.dds.lectordenotas.rest.NotitasAPIClient;

public class CalificacionTests {

	NotitasAPIClient client;
	@Before
	public void init() {
		client = NotitasAPIClient.withToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIx"
    			+ "MTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
	}
	
//	@Test
//    public void unBienMasEstaAprobado() {
//		Calificacion bienMas = client.assignments().get(1).getCalificaciones().get(0);
//        assertTrue(bienMas.getAprobado());
//    }
//
//    @Test
//    public void unDosNoEstaAprobado() {
//		Calificacion dos = client.assignments().get(0).getCalificaciones().get(0);
//        assertFalse(dos.getAprobado());
//    }
//
//    @Test
//    public void unSieteEstaAprobado() {
//    	Calificacion siete = client.assignments().get(0).getCalificaciones().get(1);
//        assertTrue(siete.getAprobado());
//    }

}
