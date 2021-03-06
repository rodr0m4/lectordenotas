package com.dds.lectordenotas.ui.vm;

import java.util.List;

import org.uqbar.commons.model.annotations.Observable;

import com.dds.lectordenotas.model.Asignacion;

@Observable
public class AsignacionesViewModel {
    private List<Asignacion> asignaciones;
    private Asignacion asignacionSeleccionada;

    public AsignacionesViewModel(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
        if (asignaciones.size() > 0) {
        	this.asignacionSeleccionada = asignaciones.get(0);
        }

    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public Asignacion getAsignacionSeleccionada() {
        return asignacionSeleccionada;
    }

    public void setAsignacionSeleccionada(Asignacion asignacionSeleccionada) {
        this.asignacionSeleccionada = asignacionSeleccionada;
    }
}
