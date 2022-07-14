package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.DTO.ItemDTO;
import com.almoxarifodase.almoxarifodase.entities.Item;
import com.almoxarifodase.almoxarifodase.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    @Transactional
    public List<ItemDTO> findAll(){
        List<Item> list = repository.findAll();
        return list.stream().map(x -> new ItemDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ItemDTO insert(ItemDTO dto){
        Item item = new Item(null, dto.getName(), dto.getQtd());
        item = repository.save(item);
        return new ItemDTO(item);
    }


}
