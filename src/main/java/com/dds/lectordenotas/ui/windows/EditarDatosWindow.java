package com.dds.lectordenotas.ui.windows;

import static com.dds.lectordenotas.model.repositories.Session.session;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import com.dds.lectordenotas.model.Estudiante;

public class EditarDatosWindow extends TransactionalDialog<Estudiante> {

    public EditarDatosWindow(WindowOwner parent, Estudiante estudiante) {
        super(parent, estudiante);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel form = new Panel(mainPanel);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Nombre:");

        Control nombre = new TextBox(form)
                .setWidth(100)
                .alignRight();
        nombre.bindValueToProperty("nombre");

        new Label(form).setText("Apellido:");

        Control apellido = new TextBox(form)
                .setWidth(100)
                .alignRight();
        apellido.bindValueToProperty("apellido");

        new Label(form).setText("Legajo:");

        Control legajo = new NumericField(form)
                .setWidth(100)
                .alignRight();
        legajo.bindValueToProperty("legajo");

        new Label(form).setText("Github:");

        Control github = new TextBox(form)
                .setWidth(100)
                .alignRight();	
        github.bindValueToProperty("github");
    }

    @Override
    protected void addActions(Panel actions) {
        new Button(actions).setCaption("Volver").onClick(this::accept).setAsDefault();
        new Button(actions).setCaption("Confirmar").onClick(() -> {
            session().getClient().modificarPerfil(getModelObject());
            EditarDatosWindow.super.showInfo("Perfil modificado");
            this.close();
        });
    }
}
