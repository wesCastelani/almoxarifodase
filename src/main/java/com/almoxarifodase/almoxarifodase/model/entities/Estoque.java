package com.almoxarifodase.almoxarifodase.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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

}
