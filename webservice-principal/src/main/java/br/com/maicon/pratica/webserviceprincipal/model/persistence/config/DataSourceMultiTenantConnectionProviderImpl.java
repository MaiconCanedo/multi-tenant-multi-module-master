package br.com.maicon.pratica.webserviceprincipal.model.persistence.config;

import br.com.maicon.pratica.webserviceprincipal.restservice.BancodeDadosRestService;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceMultiTenantConnectionProviderImpl
        extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private BancodeDadosRestService bancodeDadosRestService;

    public DataSourceMultiTenantConnectionProviderImpl(BancodeDadosRestService bancodeDadosRestService) {
        this.bancodeDadosRestService = bancodeDadosRestService;
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return bancodeDadosRestService.findAny().toDataSource();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return bancodeDadosRestService.findById(tenantIdentifier).toDataSource();
    }
}
