package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.ui.vm.EstudianteViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class VerDatosWindow extends Dialog<EstudianteViewModel> {
    public VerDatosWindow(WindowOwner owner, Estudiante estudiante) {
        super(owner, new EstudianteViewModel(estudiante));
    }

    @Override
    protected void createFormPanel(Panel panel) {
        Panel form = new Panel(panel);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Nombre:");
        new Label(form).bindValueToProperty("estudiante.nombre");

        new Label(form).setText("Apellido:");
        new Label(form).bindValueToProperty("estudiante.apellido");

        new Label(form).setText("Legajo:");
        new Label(form).bindValueToProperty("estudiante.legajo");

        new Label(form).setText("Github:");
        new Label(form).bindValueToProperty("estudiante.github");
    }

    @Override
    protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel).setCaption("Editar").setAsDefault().onClick(() -> {
           Dialog<?> editarDatosWindow = new EditarDatosWindow(this, getModelObject().getEstudiante());

           editarDatosWindow.open();
        });
    }
}
