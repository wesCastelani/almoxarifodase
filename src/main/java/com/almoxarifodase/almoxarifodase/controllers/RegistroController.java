package com.almoxarifodase.almoxarifodase.controllers;


import com.almoxarifodase.almoxarifodase.model.DTO.RegistroDTO;
import com.almoxarifodase.almoxarifodase.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RegistroController {

    @Autowired
    RegistroService service;

    @GetMapping(value = "/registros/canteiro/{nomeCanteiro}")
    public ResponseEntity<List<RegistroDTO>> listarRegistros(@PathVariable String nomeCanteiro){
        List<RegistroDTO> list = service.findByNomeCanteiro(nomeCanteiro);
        return ResponseEntity.ok().body(list);
    }


    @PostMapping(value = "/adicionarItem")
    public ResponseEntity<RegistroDTO> adicionarItem(@RequestBody RegistroDTO registroDTO){
        registroDTO = service.adicionar(registroDTO);
        return ResponseEntity.ok().body(registroDTO);
    }
    @PostMapping(value = "/retirarItem")
    public ResponseEntity<RegistroDTO> retirarItem(@RequestBody RegistroDTO registroDTO) throws Exception {
        registroDTO = service.retirar(registroDTO);
        return ResponseEntity.ok().body(registroDTO);
    }


}
