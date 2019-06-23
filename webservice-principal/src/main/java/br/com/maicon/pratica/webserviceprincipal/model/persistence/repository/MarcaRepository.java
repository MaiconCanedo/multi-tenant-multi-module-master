package br.com.maicon.pratica.webserviceprincipal.model.persistence.repository;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
