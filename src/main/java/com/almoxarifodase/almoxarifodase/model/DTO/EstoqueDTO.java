package com.almoxarifodase.almoxarifodase.model.DTO;

import com.almoxarifodase.almoxarifodase.model.entities.Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EstoqueDTO {

    private Long id;
    private String nomeCanteiro;
    private List<ItemDTO> itens = new ArrayList<>();

    public EstoqueDTO(){}

    public EstoqueDTO(Estoque entitiy) {
        this.id = entitiy.getId();
        this.nomeCanteiro = entitiy.getNomeCanteiro();
        this.itens = entitiy.getItens().stream().map(x->new ItemDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCanteiro() {
        return this.nomeCanteiro;
    }

    public void setName(String nomeCanteiro) {
        this.nomeCanteiro = nomeCanteiro;
    }

    public List<ItemDTO> getItensDTO() {
        return itens;
}

    public void setItensDTO(List<ItemDTO> itens) {
        this.itens = itens;
    }
}
