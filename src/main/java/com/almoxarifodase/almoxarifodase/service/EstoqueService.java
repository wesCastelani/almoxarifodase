package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.model.DTO.EstoqueDTO;
import com.almoxarifodase.almoxarifodase.model.DTO.ItemDTO;
import com.almoxarifodase.almoxarifodase.model.entities.Estoque;
import com.almoxarifodase.almoxarifodase.model.entities.Item;
import com.almoxarifodase.almoxarifodase.model.forms.EstoqueForm;
import com.almoxarifodase.almoxarifodase.repository.EstoqueRepository;
import com.almoxarifodase.almoxarifodase.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public List<EstoqueDTO> findAll(){
        List<Estoque> list = estoqueRepository.findAll();
        return convertListToDTO(list);
    }

    @Transactional
    public EstoqueDTO insert(EstoqueForm form){
        Estoque estoque = convertToEstoque(form);
        estoque = estoqueRepository.save(estoque);
        return new EstoqueDTO(estoque);
    }

    private Estoque convertToEstoque(EstoqueForm form) {
        Estoque estoque = new Estoque();
        estoque.setNomeCanteiro(form.getName());
        return estoque;
    }

    private EstoqueDTO convertToDTO(Estoque estoque){
        return new EstoqueDTO(estoque);
    }

    private static List<EstoqueDTO> convertListToDTO(List<Estoque> estoques) {
        return estoques.stream().map(EstoqueDTO::new).collect(Collectors.toList());
    }

}
