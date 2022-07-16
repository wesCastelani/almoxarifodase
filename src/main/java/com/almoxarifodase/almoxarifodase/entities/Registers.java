package com.almoxarifodase.almoxarifodase.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="tb_registros")
public class Registers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCanteiro;
    private String nomeItem;
    private Double qtd;
    private TipoRegistro tipo;
    private Instant moment;

    public Registers() {
    }

    public Registers(Long id, String nomeCanteiro, Double qtdDeEntrada, String nomeItem, TipoRegistro tipo, Instant moment) {
        this.id = id;
        this.nomeCanteiro = nomeCanteiro;
        this.qtd = qtdDeEntrada;
        this.nomeItem = nomeItem;
        this.tipo = tipo;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCanteiro() {
        return nomeCanteiro;
    }

    public void setNomeCanteiro(String nomeCanteiro) {
        this.nomeCanteiro = nomeCanteiro;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public TipoRegistro getTipo() {
        return tipo;
    }

    public void setTipo(TipoRegistro tipo) {
        this.tipo = tipo;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
}
