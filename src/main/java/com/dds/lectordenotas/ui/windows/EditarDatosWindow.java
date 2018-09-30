package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.ui.vm.EstudianteViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.utils.ObservableUtils;
import org.uqbar.lacar.ui.model.bindings.Observable;

import java.awt.*;
import java.util.Arrays;

import static com.dds.lectordenotas.model.repositories.Session.session;

public class EditarDatosWindow extends Dialog<EstudianteViewModel> {

    public EditarDatosWindow(WindowOwner parent, Estudiante estudiante) {
        super(parent, new EstudianteViewModel(estudiante));
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel form = new Panel(mainPanel);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Nombre:");

        Control nombre = new TextBox(form)
                .setWidth(100)
                .alignRight();
        nombre.bindValueToProperty("estudiante.nombre");

        new Label(form).setText("Apellido:");

        Control apellido = new TextBox(form)
                .setWidth(100)
                .alignRight();
        apellido.bindValueToProperty("estudiante.apellido");

        new Label(form).setText("Legajo:");

        Control legajo = new NumericField(form)
                .setWidth(100)
                .alignRight();
        legajo.bindValueToProperty("estudiante.legajo");

        new Label(form).setText("Github:");

        Control github = new TextBox(form)
                .setWidth(100)
                .alignRight();
        github.bindValueToProperty("estudiante.github");
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Volver").onClick(this::accept).setAsDefault();
        new Button(actions).setCaption("Confirmar").onClick(this::tryToUpdate);
    }

    /**
     * Trata de modificar el estudiante haciendole PUT a la api, si falla refleja el estado
     * real del recurso en el Model(sin modificar), y relanza la excepción.
     */
    public void tryToUpdate() {
        Estudiante backup = getModelObject().getEstudiante().copy();
        try {
            session().getClient().modificarPerfil(getModelObject().getEstudiante());
        } catch (Exception e) {
            getModelObject().setEstudiante(backup);
            throw e;
        }
    }
}
