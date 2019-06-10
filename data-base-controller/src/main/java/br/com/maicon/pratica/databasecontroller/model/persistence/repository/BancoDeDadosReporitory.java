package br.com.maicon.pratica.databasecontroller.model.persistence.repository;

import br.com.maicon.pratica.databasecontroller.model.entity.BancoDeDados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoDeDadosReporitory extends JpaRepository<BancoDeDados, String> {
}
