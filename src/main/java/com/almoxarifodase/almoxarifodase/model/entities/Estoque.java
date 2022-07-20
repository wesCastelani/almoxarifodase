package com.almoxarifodase.almoxarifodase.model.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name_canteiro", nullable = false, unique = true)
    private String nomeCanteiro;

    @ManyToMany
    @JoinTable(name = "tb_item_estoque", joinColumns = @JoinColumn(name = "estoque_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> itens = new HashSet<>();

    public Estoque(){}

    public Estoque(Long id, String nomeCanteiro) {
        this.id = id;
        this.nomeCanteiro = nomeCanteiro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCanteiro() {
        return this.nomeCanteiro;
    }

    public void setQtd(String name) {
        this.nomeCanteiro = name;
    }

    public Set<Item> getItens(){return itens;}

    public void setItens(Set<Item> itens){this.itens = itens;}
}
