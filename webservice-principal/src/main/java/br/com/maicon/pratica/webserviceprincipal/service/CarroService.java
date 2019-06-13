package br.com.maicon.pratica.webserviceprincipal.service;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.repository.CarroReporistory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CarroService {

    private static final String EMPTY = "";
    private CarroReporistory carroReporistory;

    public CarroService(CarroReporistory carroReporistory) {
        this.carroReporistory = carroReporistory;
    }

    public Optional<Carro> findById(Integer id) {
        return carroReporistory.findById(id);
    }

    public List<Carro> findAll(Carro carro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths(
                        isEmpty(carro.getMarca()) ? "marca" : EMPTY,
                        isEmpty(carro.getModelo()) ? "modelo" : EMPTY,
                        isEmpty(carro.getMotor()) ? "motor" : EMPTY,
                        carro.getAno() == null ? "ano" : EMPTY,
                        "id"
                )
                .withIgnoreNullValues();
        Example<Carro> example = Example.of(carro, matcher);
        return carroReporistory.findAll(example);
    }

    public Carro save(Carro carro) {
        return carroReporistory.save(carro);
    }
}
