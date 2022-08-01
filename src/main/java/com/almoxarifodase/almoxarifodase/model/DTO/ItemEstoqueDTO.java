package com.almoxarifodase.almoxarifodase.model.DTO;

import com.almoxarifodase.almoxarifodase.model.entities.Item;
import com.almoxarifodase.almoxarifodase.model.entities.ItemEstoque;
import lombok.Data;

@Data
public class ItemEstoqueDTO {

    private Long id;

    private Item item;

    private Double qtd;

    public ItemEstoqueDTO(ItemEstoque entitiy) {
        this.id = entitiy.getId();
        this.item = entitiy.getItem();
        this.qtd = entitiy.getQtd();
    }

}
