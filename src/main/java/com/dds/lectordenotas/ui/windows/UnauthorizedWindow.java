package com.dds.lectordenotas.ui.windows;

import com.dds.lectordenotas.ui.vm.LoginViewModel;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class UnauthorizedWindow extends Dialog<LoginViewModel> {
    public UnauthorizedWindow(WindowOwner owner, String failedToken) {
        super(owner, new LoginViewModel());
        getModelObject().setToken(failedToken);
    }

    @Override
    protected void createFormPanel(Panel panel) {
        new Label(panel)
                .setText(String.format("The token %s was invalid", getModelObject().getToken()))
                .alignCenter();

        new Button(panel)
                .setCaption("Entendido")
                .setAsDefault()
                .onClick(this::accept)
                .alignCenter();
    }
}
