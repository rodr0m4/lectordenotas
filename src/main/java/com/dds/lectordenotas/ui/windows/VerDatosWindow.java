package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import java.util.List;

import static com.dds.lectordenotas.model.repositories.Session.session;

public class VerDatosWindow extends Dialog<Estudiante> {
    public VerDatosWindow(WindowOwner owner, Estudiante estudiante) {
        super(owner, estudiante);
    }

    @Override
    protected void createFormPanel(Panel panel) {
        Panel form = new Panel(panel);
        form.setLayout(new ColumnLayout(2));

        generateDescriptionAndValueLabelForProp(form, "Nombre:", "nombre");
        generateDescriptionAndValueLabelForProp(form, "Apellido:", "apellido");
        generateDescriptionAndValueLabelForProp(form, "Legajo:", "legajo");
        generateDescriptionAndValueLabelForProp(form, "Github:", "github");
    }

    @Override
    protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel).setCaption("Editar").setAsDefault().onClick(() -> {
           Dialog<?> editarDatosWindow = new EditarDatosWindow(this, getModelObject());

           editarDatosWindow.open();
        });

        new Button(actionsPanel).setCaption("Ver Notas").onClick(() -> {
            List<Asignacion> asignaciones = session().getClient().assignments();

            Dialog<?> asignacionesWindow = new AsignacionesWindow(this, asignaciones);

            asignacionesWindow.open();
        });
    }

    private void generateDescriptionAndValueLabelForProp(Panel panel, String description, String property) {
        // Alternativa. Me pareció una exageración y te acoplaba a los nombres de las
        // properties (rompería encapsulamiento tambien).
        // String firstLetter = property.substring(0, 1).toUpperCase();
        // String ending = property.substring(1) + ":";
        // new Label(panel).setText(firstLetter + ending);

        new Label(panel).setText(description);
        new Label(panel).bindValueToProperty(property);
    }
}
