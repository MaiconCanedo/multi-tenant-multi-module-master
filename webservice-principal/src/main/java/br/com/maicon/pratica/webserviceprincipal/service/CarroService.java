package br.com.maicon.pratica.webserviceprincipal.service;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.repository.CarroReporistory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    private CarroReporistory carroReporistory;

    public CarroService(CarroReporistory carroReporistory) {
        this.carroReporistory = carroReporistory;
    }

    public Optional<Carro> findById(Integer id) {
        return carroReporistory.findById(id);
    }
}
