package br.com.maicon.pratica.webserviceprincipal.model.dto;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.io.Serializable;

public class BancoDeDadosDTO implements Serializable {

    private String id;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public BancoDeDadosDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataSource toDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
}
