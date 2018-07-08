package com.dds.lectordenotas.ui.vm;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import org.uqbar.commons.model.annotations.Observable;

import static com.dds.lectordenotas.model.repositories.Repositorios.*;

import java.util.List;

@Observable
public class AsignacionesViewModel {
    private Estudiante estudianteLogueado;
    private List<Asignacion> asignaciones;
    private Asignacion asignacionSeleccionada;

    public AsignacionesViewModel() {
        estudianteLogueado = ESTUDIANTE;
        asignaciones = ASIGNACIONES.delEstudiante(estudianteLogueado);
        asignacionSeleccionada = asignaciones.get(0);
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

    public void setAsignacionSeleccionada(Asignacion asignacionSeleccionada) {
        this.asignacionSeleccionada = asignacionSeleccionada;
    }
}
