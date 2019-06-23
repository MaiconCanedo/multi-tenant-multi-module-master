package br.com.maicon.pratica.databasecontroller.model.service;

import br.com.maicon.pratica.databasecontroller.model.entity.BancoDeDados;
import br.com.maicon.pratica.databasecontroller.model.persistence.repository.BancoDeDadosReporitory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoDeDadosService {

    private BancoDeDadosReporitory bancoDeDadosReporitory;

    public BancoDeDadosService(BancoDeDadosReporitory bancoDeDadosReporitory) {
        this.bancoDeDadosReporitory = bancoDeDadosReporitory;
    }

    public Optional<BancoDeDados> findById(String id) {
        return bancoDeDadosReporitory.findById(id).filter(BancoDeDados::isAtivo);
    }

    public BancoDeDados save(BancoDeDados bancoDeDados) {
        return bancoDeDadosReporitory.save(bancoDeDados);
    }

    public List<BancoDeDados> findAll() {
        return bancoDeDadosReporitory.findAll();
    }

    public Optional<BancoDeDados> findAny() {
        return bancoDeDadosReporitory.findAll().stream().findAny();
    }
}
