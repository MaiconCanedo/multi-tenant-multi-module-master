package br.com.maicon.pratica.databasecontroller.model.dto;

import br.com.maicon.pratica.databasecontroller.model.entity.BancoDeDados;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class BancoDeDadosDTO implements Serializable {

    @NotNull(message = "Id não informado")
    @Size(min = 2, max = 100, message = "Id com menos 2 ou mais que 100 caracteres")
    private String id;
    @NotNull(message = "Driver de conexão não informado")
    @Size(min = 3, max = 150, message = "Driver com menos 10 ou mais que 150 caracteres")
    private String driverClassName;
    @NotNull(message = "Caminho do banco não informado")
    private String url;
    @NotNull(message = "Usuário não informado")
    @Size(min = 2, max = 60, message = "Username com menos 2 ou mais que 6 caracteres")
    private String username;
    @Size(min = 2, max = 60, message = "Password com menos 2 ou mais que 6 caracteres")
    @NotNull(message = "Senha não informada")
    private String password;

    public BancoDeDadosDTO() {
    }

    public BancoDeDadosDTO(BancoDeDados bancoDeDados) {
        this.id = bancoDeDados.getId();
        this.driverClassName = bancoDeDados.getDriverClassName();
        this.url = bancoDeDados.getUrl();
        this.username = bancoDeDados.getUsername();
        this.password = bancoDeDados.getPassword();
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
}
