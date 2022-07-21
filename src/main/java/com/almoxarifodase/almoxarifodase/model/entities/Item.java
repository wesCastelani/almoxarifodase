package com.almoxarifodase.almoxarifodase.model.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, unique = true)
    private String name;
    @Column(name="qtd")
    private Double qtd;

    public Item(){}

    public Item(Long id, String name, Double qtd) {
        this.id = id;
        this.name = name;
        this.qtd = qtd;
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

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }
}
