package br.com.maicon.pratica.webserviceprincipal.service;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Marca;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.repository.MarcaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }
}
