package com.dds.lectordenotas.ui.vm;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import org.uqbar.commons.model.annotations.Observable;

import java.util.List;

@Observable
public class AsignacionesViewModel {
    private Estudiante estudianteLogueado;
    private List<Asignacion> asignaciones;
    private Asignacion asignacionSeleccionada;

    // TODO: Revisar si este código es correcto que esté aca.
    public AsignacionesViewModel(Estudiante estudiante) {
        this.estudianteLogueado = estudiante;
    }

    public Estudiante getEstudianteLogueado() {
        return estudianteLogueado;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public Asignacion getAsignacionSeleccionada() {
        return asignacionSeleccionada;
    }

    public void setEstudianteLogueado(Estudiante estudianteLogueado) {
        this.estudianteLogueado = estudianteLogueado;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public void setAsignacionSeleccionada(Asignacion asignacionSeleccionada) {
        this.asignacionSeleccionada = asignacionSeleccionada;
    }
}
