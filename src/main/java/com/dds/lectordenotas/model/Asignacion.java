package com.dds.lectordenotas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.uqbar.commons.model.annotations.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Asignacion {
    private int id;
    private String titulo;
    private String descripcion;
    private List<Calificacion> calificaciones;

    public Asignacion() {
    }

    public Asignacion(int id, String titulo, String descripcion, List<Calificacion> calificaciones) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificaciones = calificaciones;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @JsonProperty("description")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonProperty("grades")
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Calificacion getUltimaCalificacion() {
        return calificaciones.get(0);
    }

    public boolean hasUltimaCalificacion() {
        return calificaciones.size() > 0;
    }
}
