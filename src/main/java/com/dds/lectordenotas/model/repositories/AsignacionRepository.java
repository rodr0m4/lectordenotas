package com.dds.lectordenotas.model.repositories;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AsignacionRepository {
    private List<Asignacion> asignaciones = new ArrayList<>();

    public void agregar(Asignacion asignacion) {
        asignaciones.add(asignacion);
    }

    public List<Asignacion> delEstudiante(Estudiante estudiante) {
        return asignaciones
                .stream()
                .filter(asignacion -> estudiante.equals(asignacion.getEstudiante()))
                .collect(Collectors.toList());
    }
}
