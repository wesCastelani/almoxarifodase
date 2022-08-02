package com.almoxarifodase.almoxarifodase.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Double qtd;

    public ItemEstoque(){}
    public ItemEstoque(Item i, Double qtd){
        this.item = i;
        this.qtd = qtd;
    }

}
