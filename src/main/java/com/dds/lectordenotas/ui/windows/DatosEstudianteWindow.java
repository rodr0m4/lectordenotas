package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.ui.vm.EstudianteViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class DatosEstudianteWindow extends Dialog<EstudianteViewModel> {

    public DatosEstudianteWindow(WindowOwner parent, Estudiante estudiante) {
        super(parent, new EstudianteViewModel());
        this.getModelObject().setEstudiante(estudiante);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel form = new Panel(mainPanel);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Nombre:");
        new TextBox(form)
                .setWidth(100)
                .alignLeft()
                .bindValueToProperty("estudiante.nombre");

        new Label(form).setText("Apellido:");
        new TextBox(form)
                .setWidth(100)
                .alignLeft()
                .bindValueToProperty("estudiante.apellido");

        new Label(form).setText("Legajo:");
        new NumericField(form)
                .setWidth(100)
                .alignLeft()
                .bindValueToProperty("estudiante.legajo");

        new Label(form).setText("Github:");
        new TextBox(form)
                .setWidth(100)
                .alignLeft()
                .bindValueToProperty("estudiante.github");
    }

    @Override
    protected void addActions(Panel actions) {
        // TODO: Ver como hacer para que quede "cacheado" el modelo viejo, y en caso de cancelar, resetearlo.
        new Button(actions).setCaption("Volver").onClick(this::accept).setAsDefault();
    }

}
