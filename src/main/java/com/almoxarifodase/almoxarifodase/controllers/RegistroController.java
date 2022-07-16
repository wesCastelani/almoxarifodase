package com.almoxarifodase.almoxarifodase.controllers;


import com.almoxarifodase.almoxarifodase.DTO.RegistroDTO;
import com.almoxarifodase.almoxarifodase.entities.Registers;
import com.almoxarifodase.almoxarifodase.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class RegistroController {

    @Autowired
    RegistroService service;

    @GetMapping(value = "/registros")
    public ResponseEntity<List<RegistroDTO>> listarRegistros(){
        List<RegistroDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/adicionarItem")
    public ResponseEntity<RegistroDTO> adicionarItem(@RequestBody RegistroDTO registroDTO){
        registroDTO = service.adicionar(registroDTO);
        return ResponseEntity.ok().body(registroDTO);
    }
    @PostMapping(value = "/retirarItem")
    public ResponseEntity<Registers> retirarItem(@RequestBody Registers registers) throws Exception {
        Registers r = service.retirar(registers);
        return ResponseEntity.ok().body(r);
    }


}
