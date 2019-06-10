package br.com.maicon.pratica.webserviceprincipal.model.persistence.config;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(JpaProperties.class)
@EnableJpaRepositories(
        basePackages = "br.com.maicon.pratica.webserviceprincipal.model.persistence.repository",
        transactionManagerRef = "multiTenantManager"
)
@EnableTransactionManagement
public class MultiTenantJpaConfiguration {

    private JpaProperties jpaProperties;

    public MultiTenantJpaConfiguration(JpaProperties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Bean
    public PlatformTransactionManager multiTenantManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(
            LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        return localContainerEntityManagerFactoryBean.getObject();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            MultiTenantConnectionProvider multiTenantConnectionProvider,
            CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setPackagesToScan("br.com.maicon.pratica.webserviceprincipal.model.entity");
        result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        result.setJpaPropertyMap(getHibernateProperties(multiTenantConnectionProvider,
                currentTenantIdentifierResolver));
        return result;
    }

    private Map<String, Object> getHibernateProperties(MultiTenantConnectionProvider multiTenantConnectionProvider,
                                                       CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
        Map<String, Object> hibernateProperties =
                new LinkedHashMap<>(jpaProperties.getProperties());
        hibernateProperties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
        hibernateProperties.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER,
                multiTenantConnectionProvider);
        hibernateProperties.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER,
                currentTenantIdentifierResolver);
        return hibernateProperties;
    }
}
