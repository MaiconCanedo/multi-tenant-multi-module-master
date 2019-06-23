package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CarroSpecification implements Specification<Carro> {

    private SearchCriteria criteria;

    public CarroSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Carro> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {
        Path path = criteria.getKey().contains(".") ?
                root.join(criteria.getKey().split("\\.")[0],
                        JoinType.LEFT).get(criteria.getKey().split("\\.")[1]) :
                root.get(criteria.getKey());
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(path,
                    criteria.getValue().toString());
        }
        if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(path,
                    criteria.getValue().toString());
        }
        if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (path.getJavaType() == String.class)
                return builder.like(path,
                        "%" + criteria.getValue() + "%");
            return builder.equal(path, criteria.getValue());
        }
        return null;
    }
}
