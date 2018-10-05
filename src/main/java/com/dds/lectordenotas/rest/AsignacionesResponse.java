package com.dds.lectordenotas.rest;

import com.dds.lectordenotas.model.Asignacion;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AsignacionesResponse {
    private List<Asignacion> asignaciones;

    @JsonProperty("assignments")
    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}
