package com.almoxarifodase.almoxarifodase.model.forms;

import com.almoxarifodase.almoxarifodase.model.entities.TipoRegistro;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
public class RegistroForm {

    @NotBlank(message = "Nome do canteiro não pode estar em branco")
    private String nomeCanteiro;
    @NotBlank(message = "Nome do item não pode estar em branco")
    private String nomeItem;
    @NotBlank(message = "A quantidade do registro não pode estar em branco")
    private Double qtd;
    @NotBlank(message = "O tipo da movimentação precisa ser especificado")
    private TipoRegistro tipo;
    @NotBlank(message = "A data da movimentação não pode estar em branco")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Instant moment;
}
