package com.dds.lectordenotas.rest;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("Access Token invalido");
    }
}
