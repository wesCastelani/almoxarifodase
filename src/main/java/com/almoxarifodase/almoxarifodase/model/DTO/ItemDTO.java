package com.almoxarifodase.almoxarifodase.model.DTO;

import com.almoxarifodase.almoxarifodase.model.entities.Item;

public class ItemDTO {

    private Long id;
    private String name;

    private Double qtd;

    public ItemDTO(){}

    public ItemDTO(Item entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.qtd = entity.getQtd();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQtd() { return this.qtd;}

    public void setQtd(Double qtd){
        this.qtd = qtd;
    }
}
