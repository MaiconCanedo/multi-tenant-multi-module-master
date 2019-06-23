package br.com.maicon.pratica.webserviceprincipal.model.persistence.specification;

public class SearchCriteria {

    private String key;
    private String operation;
    private Object value;
    private Boolean orPredicate;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Boolean isOrPredicate() {
        return orPredicate != null && orPredicate;
    }

    public void setOrPredicate(Boolean orPredicate) {
        this.orPredicate = orPredicate;
    }

    public static final class Builder {
        private SearchCriteria searchCriteria;

        private Builder() {
            searchCriteria = new SearchCriteria();
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder key(String key) {
            searchCriteria.setKey(key);
            return this;
        }

        public Builder operation(String operation) {
            searchCriteria.setOperation(operation);
            return this;
        }

        public Builder value(Object value) {
            searchCriteria.setValue(value);
            return this;
        }

        public Builder orPredicate(Boolean orPredicate) {
            searchCriteria.setOrPredicate(orPredicate);
            return this;
        }

        public Builder orPredicate() {
            return orPredicate(Boolean.TRUE);
        }

        public Builder andPredicate() {
            return orPredicate(Boolean.FALSE);
        }

        public SearchCriteria build() {
            return searchCriteria;
        }
    }
}
