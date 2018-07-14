package com.dds.lectordenotas.model;

import org.uqbar.commons.model.annotations.Observable;

import java.util.Objects;

@Observable
public class CalificacionConceptual implements Calificacion {
    public enum Valor {
        MAL,
        REGULAR_MENOS,
        REGULAR,
        REGULAR_MAS,
        BIEN_MENOS,
        BIEN,
        BIEN_MAS;
    }

    private final Valor valor;

    public CalificacionConceptual(Valor valor) {
        this.valor = valor;
    }

    @Override
    public Boolean getAprobado() {
        return this.valor != Valor.MAL;
    }

    @Override
    public String toString() {
        switch (valor) {
            case MAL: return "M";
            case REGULAR_MENOS: return "R-";
            case REGULAR: return "R";
            case REGULAR_MAS: return "R+";
            case BIEN_MENOS: return "B-";
            case BIEN: return "B";
            case BIEN_MAS: return "B+";
        }

        throw new RuntimeException("No hay checkeo de exhaustividad, gran lenguaje Oracle. Podría poner un default, pero esto es un political statement");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificacionConceptual that = (CalificacionConceptual) o;
        return valor == that.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
