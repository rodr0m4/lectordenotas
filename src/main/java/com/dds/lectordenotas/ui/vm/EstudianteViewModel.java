package com.dds.lectordenotas.ui.vm;

import com.dds.lectordenotas.model.Estudiante;
import static com.dds.lectordenotas.model.repositories.Repositorios.*;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class EstudianteViewModel {

    private Estudiante estudiante;

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
