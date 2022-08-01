package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.model.DTO.ItemDTO;
import com.almoxarifodase.almoxarifodase.model.entities.Item;
import com.almoxarifodase.almoxarifodase.model.forms.ItemForm;
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
    public ItemDTO insert(ItemForm form){
        Item item = convertToItem(form);
        item = repository.save(item);
        return new ItemDTO(item);
    }


    private Item convertToItem(ItemForm form){
        Item item = new Item();
        item.setName(form.getName());
        //item.setQtd(form.getQtd());
        return item;
    }

    private ItemDTO convertToDto(Item item){
        return new ItemDTO(item);
    }

}
