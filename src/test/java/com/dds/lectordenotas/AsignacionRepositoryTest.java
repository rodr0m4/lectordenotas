package com.dds.lectordenotas;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.model.repositories.AsignacionRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AsignacionRepositoryTest {

    @Test
    public void delEstudianteTraeLasAsignacionesDelEstudiante() {
        AsignacionRepository repo = new AsignacionRepository();
        Estudiante estudiante = new Estudiante("Cosme", "Fulanito", 1337, "cf10");
        Asignacion asignacion = new Asignacion("Tomar birra", estudiante);

        assertThat(repo.delEstudiante(estudiante)).isEmpty();

        repo.agregar(asignacion);

        assertThat(repo.delEstudiante(estudiante)).containsExactly(asignacion);
    }
}
