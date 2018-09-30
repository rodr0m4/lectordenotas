package com.dds.lectordenotas.rest;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Client {
    private static final String baseUrl = "http://notitas.herokuapp.com";

    private final String authInfo;
    private final Notitas notitas;

    private Client(String authInfo, Notitas notitas) {
        this.authInfo = authInfo;
        this.notitas = notitas;
    }

    public static Client withToken(String token) {
        String authInfo = String.format("Bearer %s", token);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(defaultObjectMapper()))
                .build();

        Notitas notitas = retrofit.create(Notitas.class);

        return new Client(authInfo, notitas);
    }

    public Estudiante perfil() {
        try {
            Response<Estudiante> response = notitas.perfil(authInfo).execute();

            if (response.code() == 401) {
                throw new UnauthorizedException();
            }

            if (response.code() != 200) {
                throw new RuntimeException("Error code for response " + response + " was not 200");
            }

            return response.body();
        } catch (IOException e) {
            // TODO: Result type?
            throw new RuntimeException(e);
        }
    }

    public void modificarPerfil(Estudiante estudiante) {
        try {
            Response<Estudiante> response = notitas.modificarPerfil(authInfo, estudiante).execute();

            if (response.code() == 401) {
                throw new UnauthorizedException();
            }

            if (response.code() != 201) {
                throw new RuntimeException("Error code for response " + response + " was not 201");
            }
        } catch (IOException e) {
            // TODO: Result type?
            throw new RuntimeException(e);
        }
    }

    public List<Asignacion> assignments() {
        try {
            Response<List<Asignacion>> response = notitas.asignaciones(authInfo).execute();

            if (response.code() == 401) {
                throw new UnauthorizedException();
            }

            if (response.code() != 200) {
                throw new RuntimeException("Error code for response " + response + " was not 200");
            }

            return response.body();
        } catch (IOException e) {
            // TODO: Result type?
            throw new RuntimeException(e);
        }
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public static ObjectMapper defaultObjectMapper() {
        return new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, true)
                .setSerializationInclusion(JsonInclude.Include.NON_ABSENT)
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }
}
