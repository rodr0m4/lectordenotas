package com.dds.lectordenotas.model;

import org.uqbar.commons.model.annotations.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Asignacion {
    private String tarea;
    private Estudiante estudiante;
    private List<Calificacion> calificaciones;

    public Asignacion(String tarea, Estudiante estudiante, List<Calificacion> calificaciones) {
        this.tarea = tarea;
        this.estudiante = estudiante;
        this.calificaciones = calificaciones;
    }

    public Asignacion(String tarea, Estudiante estudiante) {
        this.tarea = tarea;
        this.estudiante = estudiante;
        this.calificaciones = new ArrayList<>();
    }

    public String getTarea() {
        return tarea;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public Calificacion getUltimaCalificacion() {
        return calificaciones.stream().reduce((una, otra) -> otra).orElse(null);
    }

    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }
}
