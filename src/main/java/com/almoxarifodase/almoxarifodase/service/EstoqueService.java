package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.DTO.EstoqueDTO;
import com.almoxarifodase.almoxarifodase.DTO.ItemDTO;
import com.almoxarifodase.almoxarifodase.entities.*;
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
        return list.stream().map(x -> new EstoqueDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public EstoqueDTO insert(EstoqueDTO dto){
        Estoque estoque = new Estoque(null, dto.getName());
        for(ItemDTO i : dto.getItensDTO()){
            Item item = itemRepository.getOne(i.getId());
            estoque.getItens().add(item);
        }
        estoque = estoqueRepository.save(estoque);
        return new EstoqueDTO(estoque);
    }

    @Transactional
    public Registers addNewItem(Registers registers){
        Estoque estoque = estoqueRepository.findByName(registers.getNomeCanteiro());
        Item item = itemRepository.findByName(registers.getNomeItem());
        item.setQtd(registers.getQtd() + item.getQtd());
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        return registers;
    }

    @Transactional
    public NovaSaida withdrawal(Long estoqueId, Long itemId, Double qtd) throws Exception {
        Estoque estoque = estoqueRepository.getOne(estoqueId);
        Item item = itemRepository.getOne(itemId);
        if(item.getQtd() < qtd){
            throw new Exception();
        }else{
            item.setQtd(item.getQtd() - qtd);
        }
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        return new NovaSaida(estoque.getName(), qtd, item.getName());
    }

}
