package com.dds.lectordenotas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.uqbar.commons.model.annotations.Observable;

import java.time.Instant;

@Observable
public class Calificacion {
    private int id;
    private Object valor;
    private Instant creadoEl;
    private Instant actualizadoEl;

    public Calificacion() { }

    public Calificacion(int id, Object valor, Instant creadoEl, Instant actualizadoEl) {
        this.id = id;
        this.valor = valor;
        this.creadoEl = creadoEl;
        this.actualizadoEl = actualizadoEl;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("value")
    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @JsonProperty("created_at")
    public Instant getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Instant creadoEl) {
        this.creadoEl = creadoEl;
    }

    @JsonProperty("updated_at")
    public Instant getActualizadoEl() {
        return actualizadoEl;
    }

    public void setActualizadoEl(Instant actualizadoEl) {
        this.actualizadoEl = actualizadoEl;
    }

    public boolean getAprobado() {
        // Don't dead open inside
        try {
            Integer numerico = (Integer) valor;

            return numerico > 5;
        } catch (ClassCastException e) {
            try {
                String stringy = (String) valor;

                return !"M".equals(stringy);
            } catch (ClassCastException cce) {
                throw new RuntimeException(cce);
            }
        }
    }
}
