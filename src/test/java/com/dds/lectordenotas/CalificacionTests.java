package com.dds.lectordenotas;

import com.dds.lectordenotas.model.Calificacion;
import com.dds.lectordenotas.model.CalificacionConceptual;
import com.dds.lectordenotas.model.CalificacionNumerica;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalificacionTests {

    final Calificacion mal = new CalificacionConceptual(CalificacionConceptual.Valor.MAL);
    final Calificacion bien = new CalificacionConceptual(CalificacionConceptual.Valor.BIEN);
    final Calificacion dos = new CalificacionNumerica(2);
    final Calificacion seis = new CalificacionNumerica(6);

    @Test
    public void unMalNoEstaAprobado() {
        assertEquals(false, mal.getAprobado());
    }

    @Test
    public void unBienEstaAprobado() {
        assertEquals(true, bien.getAprobado());
    }

    @Test
    public void unDosNoEstaAprobado() {
        assertEquals(false, dos.getAprobado());
    }

    @Test
    public void unSeisEstaAprobado() {
        assertEquals(true, seis.getAprobado());
    }

    @Test
    public void conceptualesSeVenBien() {
        assertEquals("M", mal.toString());
        assertEquals("B", bien.toString());
    }

    @Test
    public void numericasSeVenBien() {
        assertEquals("2", dos.toString());
        assertEquals("6", seis.toString());
    }
}
