package com.almoxarifodase.almoxarifodase.entities;

public class Registers {

    private String nomeCanteiro;
    private String nomeItem;
    private Double qtd;
    private TipoRegistro tipo;

    public Registers() {
    }

    public Registers(String nomeCanteiro, Double qtdDeEntrada, String nomeItem, TipoRegistro tipo) {
        this.nomeCanteiro = nomeCanteiro;
        this.qtd = qtdDeEntrada;
        this.nomeItem = nomeItem;
        this.tipo = tipo;
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
}
