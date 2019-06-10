package br.com.maicon.pratica.webserviceprincipal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class
        },
        scanBasePackages = {
                "br.com.maicon.pratica.webserviceprincipal"
        }
)
public class WebservicePrincipalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebservicePrincipalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
