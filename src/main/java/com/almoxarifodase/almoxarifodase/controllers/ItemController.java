package com.almoxarifodase.almoxarifodase.controllers;

import com.almoxarifodase.almoxarifodase.model.DTO.ItemDTO;
import com.almoxarifodase.almoxarifodase.model.forms.ItemForm;
import com.almoxarifodase.almoxarifodase.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/itens")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll(){
        List<ItemDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> insert(@RequestBody @Valid ItemForm form){
        ItemDTO dto = service.insert(form);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

}
