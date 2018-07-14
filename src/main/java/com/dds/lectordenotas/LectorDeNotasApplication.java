package com.dds.lectordenotas;

import com.dds.lectordenotas.model.Fixture;
import com.dds.lectordenotas.ui.windows.AsignacionesWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import static com.dds.lectordenotas.model.repositories.Repositorios.estudiante;

public class LectorDeNotasApplication extends Application {

    public static void main(String[] args) {
        new LectorDeNotasApplication().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        Fixture.init();
        return new AsignacionesWindow(this, estudiante());
    }
}
