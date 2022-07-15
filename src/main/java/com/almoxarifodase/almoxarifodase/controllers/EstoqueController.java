package com.almoxarifodase.almoxarifodase.controllers;

import com.almoxarifodase.almoxarifodase.DTO.EstoqueDTO;
import com.almoxarifodase.almoxarifodase.entities.Registers;
import com.almoxarifodase.almoxarifodase.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping(value="/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @GetMapping(value = "/estoque")
    public ResponseEntity<List<EstoqueDTO>> findAll(){
        List<EstoqueDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/estoque")
    public ResponseEntity<EstoqueDTO> insert(@RequestBody EstoqueDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
