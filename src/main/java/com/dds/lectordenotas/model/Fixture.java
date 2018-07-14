package com.dds.lectordenotas.model;


import java.util.Arrays;

import static com.dds.lectordenotas.model.repositories.Repositorios.*;

public class Fixture {

    public static void init() {
        asignaciones().agregar(new Asignacion("Primer parcial DDS", estudiante(), Arrays.asList(new CalificacionNumerica(2), new CalificacionNumerica(8))));
        asignaciones().agregar(new Asignacion("TP Arena", estudiante(), Arrays.asList(new CalificacionConceptual(CalificacionConceptual.Valor.MAL))));
    }
}
