package br.com.maicon.pratica.webserviceprincipal.model.persistence.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    private static final String DEFAULT_TENANT_ID = "empresa01";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String currentTenantId = TenantContext.getTenantId();
        return (currentTenantId != null) ? currentTenantId : DEFAULT_TENANT_ID;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
