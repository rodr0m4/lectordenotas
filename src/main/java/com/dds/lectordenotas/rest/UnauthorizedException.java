package com.dds.lectordenotas.rest;

public class UnauthorizedException extends RestException {
    public UnauthorizedException() {
        super(401);
    }
}
