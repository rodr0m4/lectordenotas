package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.ui.utils.ReadOnlyTransformer;
import com.dds.lectordenotas.ui.vm.AsignacionesViewModel;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.utils.ObservableUtils;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import java.util.List;

public class AsignacionesWindow extends Dialog<AsignacionesViewModel> {

    public AsignacionesWindow(WindowOwner parent, List<Asignacion> asignaciones) {
        super(parent, new AsignacionesViewModel(asignaciones));
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel parentContainer = new Panel(mainPanel);
        parentContainer.setLayout(new VerticalLayout());
        
        Panel saludador = new Panel(parentContainer);
        saludador.setLayout(new HorizontalLayout());

        Panel form = new Panel(parentContainer);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Tareas:");

        Selector<Asignacion> asignacionSelector = new Selector<>(form);
        asignacionSelector.allowNull(false);
        asignacionSelector.bindValueToProperty("asignacionSeleccionada");
        Binding<Asignacion, Selector<Asignacion>, ListBuilder<Asignacion>> itemBinding = asignacionSelector.bindItems(new ObservableProperty<>("asignaciones"));
        itemBinding.setAdapter(new PropertyAdapter(Asignacion.class, "titulo"));


        if (getModelObject().getAsignacionSeleccionada().hasUltimaCalificacion()) {
            new Label(form).setText("Aprobó?");
            new Label(form)
                    .bindValueToProperty("asignacionSeleccionada.ultimaCalificacion.aprobado")
                    .setTransformer(ReadOnlyTransformer.fromClosure((Boolean aprobo) -> aprobo ? "Si" : "No", boolean.class, String.class));
        }


        Panel botonera = new Panel(parentContainer);
        botonera.setLayout(new HorizontalLayout());

        Button salir =
                new Button(botonera)
                .setCaption("Salir")
                .onClick(this::cancel);
    }
}
