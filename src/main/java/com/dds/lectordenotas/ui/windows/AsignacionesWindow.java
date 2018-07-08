package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.ui.vm.AsignacionesViewModel;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.bindings.ValueTransformer;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

public class AsignacionesWindow extends Dialog<AsignacionesViewModel> {

    public AsignacionesWindow(WindowOwner parent) {
        super(parent, new AsignacionesViewModel());
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        Panel parentContainer = new Panel(mainPanel);
        parentContainer.setLayout(new VerticalLayout());
        
        Panel saludador = new Panel(parentContainer);
        saludador.setLayout(new HorizontalLayout());
        // Por que no hay un Transformer mas simple para properties que SABES que no vas a editar desde ponele, un LABEL?
        // Algo que reciba un Function<Model, View> ? La verbosidad es demasiada.
        // Si no, hace que un hack horrible como este sea mucho menos verbose y facil de escribir :rolling_eyes:
        new Label(saludador).setText("Hola");
        new Label(saludador).bindValueToProperty("estudianteLogueado.nombre");
        new Label(saludador).setText("!");

        Panel form = new Panel(parentContainer);
        form.setLayout(new ColumnLayout(2));

        new Label(form).setText("Tareas:");

        Selector<Asignacion> asignacionSelector = new Selector<>(form);
        asignacionSelector.allowNull(false);
        asignacionSelector.bindValueToProperty("asignacionSeleccionada");
        Binding<Asignacion, Selector<Asignacion>, ListBuilder<Asignacion>> itemBinding = asignacionSelector.bindItems(new ObservableProperty<>("asignaciones"));
        itemBinding.setAdapter(new PropertyAdapter(Asignacion.class, "tarea"));

        new Label(form).setText("Calificacion Actual:");
        new Label(form).bindValueToProperty("asignacionSeleccionada.ultimaCalificacion");

        new Label(form).setText("Aprobó?");
        new Label(form).bindValueToProperty("asignacionSeleccionada.ultimaCalificacion.aprobado");
        // Falta que se vea mas lindo el valor. Pero sigue teniendo el mismo problema de arriba.


        Panel botonera = new Panel(parentContainer);
        botonera.setLayout(new HorizontalLayout());

        Button salir =
                new Button(botonera)
                .setCaption("Salir")
                .setAsDefault()
                .onClick(this::cancel);

        Button aDatosEstudiante =
                new Button(botonera)
                .setCaption("Editar datos")
                .onClick(this::editarDatos);
    }

    private void editarDatos() {
        Dialog<?> window = new DatosEstudianteWindow(this);

        window.open();
        // ???
        window.onAccept(() -> {});
    }
}
