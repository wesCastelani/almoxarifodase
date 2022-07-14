package com.almoxarifodase.almoxarifodase.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "tb_item_estoque", joinColumns = @JoinColumn(name = "estoque_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> itens = new HashSet<>();

    public Estoque(){}

    public Estoque(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setQtd(String name) {
        this.name = name;
    }

    public Set<Item> getItens(){return itens;}

    public void setItens(Set<Item> itens){this.itens = itens;}
}
