package br.com.maicon.pratica.webserviceprincipal.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 65)
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "fk_marca", nullable = false)
    private Marca marca;
    @Column(nullable = false)
    private Integer ano;
    private String motor;

    public Carro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca.getDescricao() + '\'' +
                ", ano=" + ano +
                ", motor='" + motor + '\'' +
                '}';
    }
}

