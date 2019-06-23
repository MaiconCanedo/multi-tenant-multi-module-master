package br.com.maicon.pratica.webserviceprincipal.model.persistence.repository;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarroReporistory extends JpaRepository<Carro, Integer>,
        JpaSpecificationExecutor<Carro> {

}
