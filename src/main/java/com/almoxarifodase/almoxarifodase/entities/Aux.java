package com.almoxarifodase.almoxarifodase.entities;

public class Aux {

    private Long estoqueId;
    private Long itemId;
    private Double qtd;

    public Aux() {
    }

    public Aux(Long estoqueId, Long itemId, Double qtd) {
        this.estoqueId = estoqueId;
        this.itemId = itemId;
        this.qtd = qtd;
    }

    public Long getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Long estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }
}
