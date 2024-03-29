package br.com.maicon.pratica.webserviceprincipal.restservice.api;

import br.com.maicon.pratica.webserviceprincipal.model.dto.BancoDeDadosDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface BancoDeDadosApi {

    @GET("bancodedados/{id}")
    Call<BancoDeDadosDTO> findById(@Path("id") String id);

    @GET("bancodedados")
    Call<List<BancoDeDadosDTO>> findAll();

    @GET("bancodedados/qualquer")
    Call<BancoDeDadosDTO> findAny();

    @POST("bancodedados")
    Call<Void> save(@Body BancoDeDadosDTO bancoDeDadosDTO);
}
