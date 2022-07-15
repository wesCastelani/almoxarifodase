package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.DTO.EstoqueDTO;
import com.almoxarifodase.almoxarifodase.DTO.RegistroDTO;
import com.almoxarifodase.almoxarifodase.entities.Estoque;
import com.almoxarifodase.almoxarifodase.entities.Item;
import com.almoxarifodase.almoxarifodase.entities.Registers;
import com.almoxarifodase.almoxarifodase.repository.EstoqueRepository;
import com.almoxarifodase.almoxarifodase.repository.ItemRepository;
import com.almoxarifodase.almoxarifodase.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RegistroService {

    @Autowired
    EstoqueRepository estoqueRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RegistroRepository registroRepository;


    @Transactional
    public List<RegistroDTO> findAll(){
        List<Registers> list = registroRepository.findAll();
        return list.stream().map(x -> new RegistroDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public Registers adicionar(Registers register){
        Estoque estoque = estoqueRepository.findByName(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        item.setQtd(register.getQtd() + item.getQtd());
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return register;
    }

    @Transactional
    public Registers retirar(Registers register) throws Exception {
        Estoque estoque = estoqueRepository.findByName(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        if(item.getQtd() < register.getQtd()){
            throw new Exception();
        }else{
            item.setQtd(item.getQtd() - register.getQtd());
        }
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return register;
    }

}
