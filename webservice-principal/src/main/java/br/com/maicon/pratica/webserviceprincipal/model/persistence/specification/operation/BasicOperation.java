package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.operation;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface BasicOperation {

    boolean isValid(SearchCriteria searchCriteria);

    Predicate toPredicate(Root<Carro> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}
