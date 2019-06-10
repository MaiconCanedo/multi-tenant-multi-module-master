package br.com.maicon.pratica.databasecontroller.model.entity;

import br.com.maicon.pratica.databasecontroller.model.dto.BancoDeDadosDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BancoDeDados {

    @Id
    @Column(length = 100)
    private String id;
    @Column(nullable = false, length = 150)
    private String driverClassName;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false, length = 60)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false)
    private Boolean ativo;

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

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public static BancoDeDados of(BancoDeDadosDTO bancoDeDadosDTO) {
        return BancoDeDados.Builder.create()
                .ativo()
                .id(bancoDeDadosDTO.getId())
                .driverClassName(bancoDeDadosDTO.getDriverClassName())
                .url(bancoDeDadosDTO.getUrl())
                .username(bancoDeDadosDTO.getUsername())
                .password(bancoDeDadosDTO.getPassword())
                .build();
    }

    public static final class Builder {
        private BancoDeDados bancoDeDados;

        private Builder() {
            bancoDeDados = new BancoDeDados();
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder ativo() {
            bancoDeDados.setAtivo(Boolean.TRUE);
            return this;
        }

        public Builder inativo() {
            bancoDeDados.setAtivo(Boolean.FALSE);
            return this;
        }

        public Builder id(String id) {
            bancoDeDados.setId(id);
            return this;
        }

        public Builder driverClassName(String driveClassName) {
            bancoDeDados.setDriverClassName(driveClassName);
            return this;
        }

        public Builder url(String url) {
            bancoDeDados.setUrl(url);
            return this;
        }

        public Builder username(String username) {
            bancoDeDados.setUsername(username);
            return this;
        }

        public Builder password(String password) {
            bancoDeDados.setPassword(password);
            return this;
        }

        public BancoDeDados build() {
            return bancoDeDados;
        }
    }
}
