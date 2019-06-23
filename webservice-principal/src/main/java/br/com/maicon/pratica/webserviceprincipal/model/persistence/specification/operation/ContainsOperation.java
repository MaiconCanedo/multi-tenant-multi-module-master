package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.operation;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ContainsOperation implements BasicOperation {

    private SearchCriteria criteria;

    @Override
    public boolean isValid(SearchCriteria searchCriteria) {
        this.criteria = searchCriteria;
        return true;
    }

    @Override
    public Predicate toPredicate(Root<Carro> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (root.get(criteria.getKey()).getJavaType() == String.class)
            return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
    }
}
