package com.almoxarifodase.almoxarifodase.entities;

public class NovaSaida {

    private String nomeCanteiro;
    private String nomeItem;
    private Double qtdDeEntrada;

    public NovaSaida() {
    }

    public NovaSaida(String nomeCanteiro, Double qtdDeEntrada, String nomeItem) {
        this.nomeCanteiro = nomeCanteiro;
        this.qtdDeEntrada = qtdDeEntrada;
        this.nomeItem = nomeItem;
    }

    public String getNomeCanteiro() {
        return nomeCanteiro;
    }

    public void setNomeCanteiro(String nomeCanteiro) {
        this.nomeCanteiro = nomeCanteiro;
    }

    public Double getQtdDeEntrada() {
        return qtdDeEntrada;
    }

    public void setQtdDeEntrada(Double qtdDeEntrada) {
        this.qtdDeEntrada = qtdDeEntrada;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
}
