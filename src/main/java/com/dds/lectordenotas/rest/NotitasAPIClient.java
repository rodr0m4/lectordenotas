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
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public class NotitasAPIClient {
    private static final String baseUrl = "http://notitas.herokuapp.com";

    private final String authInfo;
    private final NotitasAPISpec notitas;

    private NotitasAPIClient(String authInfo, NotitasAPISpec notitas) {
        this.authInfo = authInfo;
        this.notitas = notitas;
    }

    public static NotitasAPIClient withToken(String token) {
        String authInfo = String.format("Bearer %s", token);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(defaultObjectMapper()))
                .build();

        NotitasAPISpec notitas = retrofit.create(NotitasAPISpec.class);

        return new NotitasAPIClient(authInfo, notitas);
    }

    public Estudiante perfil() {
        try {
            Response<Estudiante> response = notitas.perfil(authInfo).execute();

            Optional<Estudiante> estudiante = validateResponse(response);

            // Estoy seguro de que va a existir el estudiante
            return estudiante.get();
        } catch (IOException e) {
            // TODO: Result type?
            throw new RuntimeException(e);
        }
    }

    public void modificarPerfil(Estudiante estudiante) {
        try {
            Response<ResponseBody> response = notitas.modificarPerfil(authInfo, estudiante).execute();

            validateResponse(response);
        } catch (IOException e) {
            // TODO: Result type?
            throw new RuntimeException(e);
        }
    }

    public List<Asignacion> assignments() {
        try {
            Response<AsignacionesResponse> response = notitas.asignaciones(authInfo).execute();

            Optional<AsignacionesResponse> maybeAsignaciones = validateResponse(response);

            return maybeAsignaciones
                    .map(AsignacionesResponse::getAsignaciones)
                    .orElse(emptyList());
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

    private <T> Optional<T> validateResponse(Response<T> response) {
        if (response.code() == 401) {
            throw new UnauthorizedException();
        }

        if (response.code() != 200) {
            throw new RestException(response.code());
        }

        return Optional.ofNullable(response.body());
    }
}
