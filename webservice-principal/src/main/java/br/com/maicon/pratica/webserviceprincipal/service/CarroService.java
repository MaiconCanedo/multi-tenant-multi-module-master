package br.com.maicon.pratica.webserviceprincipal.service;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.repository.CarroReporistory;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.CarroSpecificationsBuilder;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.SearchCriteria;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

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

    public List<Carro> findAll() {
        return carroReporistory.findAll();
    }

    public List<Carro> findAll(Carro carro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths(
                        carro.getMarca() == null ? "marca" : EMPTY,
                        isEmpty(carro.getModelo()) ? "modelo" : EMPTY,
                        isEmpty(carro.getMotor()) ? "motor" : EMPTY,
                        carro.getAno() == null ? "ano" : EMPTY,
                        "id"
                )
                .withIgnoreNullValues();
        Example<Carro> example = Example.of(carro, matcher);
        return carroReporistory.findAll(example);
    }

    public List<Carro> findByModeloAndAno(Carro carro) {
        CarroSpecificationsBuilder builder =
                new CarroSpecificationsBuilder();
        valid(builder, "modelo", carro.getModelo());
        valid(builder, "ano", carro.getAno());
        valid(builder, "motor", carro.getMotor());
        valid(builder, "marca.descricao", carro.getMarca().getDescricao());
        return carroReporistory.findAll(builder.build());
    }

    public Carro save(Carro carro) {
        return carroReporistory.save(carro);
    }

    private void valid(CarroSpecificationsBuilder builder, String key, String value) {
        if (isNotEmpty(value))
            builder.with(SearchCriteria.Builder.create()
                    .key(key)
                    .operation(":")
                    .andPredicate()
                    .value(value)
                    .build());
    }

    private void valid(CarroSpecificationsBuilder builder, String key, Integer value) {
        if (value != null)
            builder.with(SearchCriteria.Builder.create()
                    .key(key)
                    .operation(">")
                    .andPredicate()
                    .value(value)
                    .build());
    }
}
