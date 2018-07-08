package com.dds.lectordenotas.model;

import org.uqbar.commons.model.annotations.Observable;

import java.util.Objects;

@Observable
public class CalificacionNumerica implements Calificacion {
    private final int numero;

    public CalificacionNumerica(int numero) {
        if (numero < 1 || numero > 10)
            throw new IllegalArgumentException();
        this.numero = numero;
    }

    @Override
    public boolean getAprobado() {
        return numero > 5;
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificacionNumerica that = (CalificacionNumerica) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {

        return Objects.hash(numero);
    }
}
