package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification;

import br.com.maicon.pratica.webserviceprincipal.model.entity.Carro;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarroSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public CarroSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public CarroSpecificationsBuilder with(String key,
                                           String operation,
                                           Object value) {
        return with(SearchCriteria.Builder.create()
                .key(key)
                .operation(operation)
                .value(value).build());
    }

    public CarroSpecificationsBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Carro> build() {
        if (params.isEmpty())
            return null;
        List<Specification<Carro>> specifications = params.stream()
                .map(CarroSpecification::new)
                .collect(Collectors.toList());
        Specification<Carro> result = specifications.get(0);
        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate() ?
                    Specification.where(result)
                            .or(specifications.get(i)) :
                    Specification.where(result)
                            .and(specifications.get(i));
        }
        return result;
    }
}
