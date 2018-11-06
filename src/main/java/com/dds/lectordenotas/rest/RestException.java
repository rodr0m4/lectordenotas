package com.dds.lectordenotas.rest;

public class RestException extends RuntimeException {
    public RestException(int codigo) {
        super("El request HTTP no fue exitoso, el codigo es " + codigo);
    }
}
