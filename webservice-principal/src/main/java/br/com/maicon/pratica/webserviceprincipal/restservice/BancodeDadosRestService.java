package br.com.maicon.pratica.webserviceprincipal.restservice;

import br.com.maicon.pratica.webserviceprincipal.model.dto.BancoDeDadosDTO;
import br.com.maicon.pratica.webserviceprincipal.model.exception.BadRequestExecption;
import br.com.maicon.pratica.webserviceprincipal.restservice.api.BancoDeDadosApi;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BancodeDadosRestService {

    private BancoDeDadosApi bancoDeDadosApi;

    public BancodeDadosRestService(BancoDeDadosApi bancoDeDadosApi) {
        this.bancoDeDadosApi = bancoDeDadosApi;
    }

    public BancoDeDadosDTO findById(String id) {
        try {
            return bancoDeDadosApi.findById(id).execute().body();
        } catch (IOException e) {
            throw new BadRequestExecption(e.getMessage());
        }
    }

    public List<BancoDeDadosDTO> findAll() {
        try {
            return bancoDeDadosApi.findAll().execute().body();
        } catch (IOException e) {
            throw new BadRequestExecption(e.getMessage());
        }
    }

    public BancoDeDadosDTO findAny() {
        try {
            return bancoDeDadosApi.findAny().execute().body();
        } catch (IOException e) {
            throw new BadRequestExecption(e.getMessage());
        }
    }
}
