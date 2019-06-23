/*
package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.operation;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.specification.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public enum SearchOperation {
    CONTAINS(new ContainsOperation()),
    EQUAL,
    GREATER_THAN_OR_EQUAL,
    LESS_THAN_OR_EQUAL,
    DEFAULT(new DefaultOperation());

    private BasicOperation basicOperation;

    SearchOperation(BasicOperation basicOperation) {
        this.basicOperation = basicOperation;
    }

    public BasicOperation getBasicOperation() {
        return basicOperation;
    }

    private static class DefaultOperation implements BasicOperation {

        @Override
        public boolean isValid(SearchCriteria searchCriteria) {
            return true;
        }

        @Override
        public Predicate toPredicate(Root<Carro> root,
                                     CriteriaQuery<?> query,
                                     CriteriaBuilder builder) {
            return null;
        }
    }
}
*/
