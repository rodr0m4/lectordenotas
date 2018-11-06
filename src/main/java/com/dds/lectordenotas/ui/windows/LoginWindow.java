package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.model.Estudiante;
import com.dds.lectordenotas.rest.NotitasAPIClient;
import com.dds.lectordenotas.rest.UnauthorizedException;
import com.dds.lectordenotas.ui.vm.LoginViewModel;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import static com.dds.lectordenotas.model.repositories.Session.*;

public class LoginWindow extends Dialog<LoginViewModel> {
    public LoginWindow(WindowOwner owner) {
        super(owner, new LoginViewModel());
    }

    @Override
    protected void createFormPanel(Panel panel) {
        Panel form = new Panel(panel);
        form.setLayout(new ColumnLayout(1));

        new Label(form)
                .setText("Por favor ingrese su token:")
                .alignCenter();

        new TextBox(form)
                .setWidth(100)
                .alignCenter()
                .bindValueToProperty("token");

        new Button(panel)
                .setCaption("Ingresar")
                .setAsDefault()
                .onClick(this::login);
    }

    private void login() {
        try {
            session().setClient(
                    NotitasAPIClient.withToken(getModelObject().getToken())
            );
            Estudiante estudiante = session().getClient().perfil();

            Dialog<?> verDatosWindow = new VerDatosWindow(this, estudiante);
            verDatosWindow.open();
        } catch (UnauthorizedException e) {
            Dialog<?> unauthorizedWindow = new UnauthorizedWindow(this, getModelObject().getToken());
            unauthorizedWindow.open();
        }
    }
}
