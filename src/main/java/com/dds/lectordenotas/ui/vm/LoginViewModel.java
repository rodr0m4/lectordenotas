package com.dds.lectordenotas.ui.vm;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class LoginViewModel {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
