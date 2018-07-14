package com.dds.lectordenotas.model.repositories;

import com.dds.lectordenotas.model.Estudiante;

public class Repositorios {
    private static final Estudiante ESTUDIANTE = new Estudiante("Rodrigo", "Martin", 1602550, "rodroma");
    private static final AsignacionRepository ASIGNACIONES = new AsignacionRepository();

    public static Estudiante estudiante() { return ESTUDIANTE; }
    public static AsignacionRepository asignaciones() { return ASIGNACIONES; }
}
