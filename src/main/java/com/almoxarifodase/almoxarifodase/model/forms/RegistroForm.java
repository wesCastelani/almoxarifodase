package com.almoxarifodase.almoxarifodase.model.forms;

import com.almoxarifodase.almoxarifodase.model.entities.TipoRegistro;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class RegistroForm {

    @NotBlank(message = "Nome do canteiro não pode estar em branco")
    private String nomeCanteiro;
    @NotBlank(message = "Nome do item não pode estar em branco")
    private String nomeItem;
    @NotNull(message = "A quantidade do item não pode estar em branco")
    private Double qtd;
    @NotNull(message = "O tipo da movimentação precisa ser especificado")
    private TipoRegistro tipo;

    private Instant moment;
}
