package com.dds.lectordenotas.model;


import java.util.Arrays;

import static com.dds.lectordenotas.model.repositories.Repositorios.*;

public class Fixture {

    public static void init() {
        ASIGNACIONES.agregar(new Asignacion("Primer parcial DDS", ESTUDIANTE, Arrays.asList(new CalificacionNumerica(2), new CalificacionNumerica(8))));
        ASIGNACIONES.agregar(new Asignacion("TP Arena", ESTUDIANTE, Arrays.asList(new CalificacionConceptual(CalificacionConceptual.Valor.MAL))));
    }
}
