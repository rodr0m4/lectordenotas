package com.dds.lectordenotas.rest;

import com.dds.lectordenotas.model.Asignacion;
import com.dds.lectordenotas.model.Estudiante;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;

import java.util.List;

public interface Notitas {
    @GET("student")
    Call<Estudiante> perfil(@Header("Authorization") String authInfo);

    @PUT("student")
    Call<ResponseBody> modificarPerfil(@Header("Authorization") String authInfo, @Body Estudiante estudiante);

    @GET("student/assignments")
    Call<AsignacionesResponse> asignaciones(@Header("Authorization") String authInfo);
}
