package br.com.maicon.pratica.webserviceprincipal.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 65, nullable = false, unique = true)
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(descricao, marca.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }
}
