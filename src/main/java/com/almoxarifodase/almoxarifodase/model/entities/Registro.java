package com.almoxarifodase.almoxarifodase.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Table(name="tb_registros")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_canteiro", nullable = false)
    private String nomeCanteiro;
    @Column(name = "nome_item", nullable = false)
    private String nomeItem;
    @Column(name = "qtd", nullable = false)
    private Double qtd;
    @Column(name = "tipo_registro")
    private TipoRegistro tipo;
    @Column(name = "data", nullable = false)
    private Instant moment;

    public Registro() {
    }

    public Registro(Long id, String nomeCanteiro, Double qtdDeEntrada, String nomeItem, TipoRegistro tipo, Instant moment) {
        this.id = id;
        this.nomeCanteiro = nomeCanteiro;
        this.qtd = qtdDeEntrada;
        this.nomeItem = nomeItem;
        this.tipo = tipo;
        this.moment = moment;
    }

}
