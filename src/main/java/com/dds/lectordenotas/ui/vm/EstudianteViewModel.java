package com.dds.lectordenotas.ui.vm;

import com.dds.lectordenotas.model.Estudiante;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class EstudianteViewModel {

    private Estudiante estudiante;

    public EstudianteViewModel(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
