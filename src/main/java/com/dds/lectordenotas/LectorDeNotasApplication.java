package com.dds.lectordenotas;

import com.dds.lectordenotas.ui.windows.LoginWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

public class LectorDeNotasApplication extends Application {

    public static void main(String[] args) {
        new LectorDeNotasApplication().start();
    }

    @Override
    protected Window<?> createMainWindow() {
        return new LoginWindow(this);
    }
}
