package com.almoxarifodase.almoxarifodase.model.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, unique = true)
    private String name;
    @Column(name="qtd")
    private Double qtd;

}
