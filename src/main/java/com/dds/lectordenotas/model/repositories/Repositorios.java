package com.dds.lectordenotas.model.repositories;

import com.dds.lectordenotas.model.Estudiante;

public class Repositorios {
    public static final Estudiante ESTUDIANTE = new Estudiante("Rodrigo", "Martin", 1602550, "rodroma");
    public static final AsignacionRepository ASIGNACIONES = new AsignacionRepository();
}
