package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.model.DTO.RegistroDTO;
import com.almoxarifodase.almoxarifodase.model.entities.Estoque;
import com.almoxarifodase.almoxarifodase.model.entities.Item;
import com.almoxarifodase.almoxarifodase.model.entities.Registro;
import com.almoxarifodase.almoxarifodase.model.forms.RegistroForm;
import com.almoxarifodase.almoxarifodase.repository.EstoqueRepository;
import com.almoxarifodase.almoxarifodase.repository.ItemRepository;
import com.almoxarifodase.almoxarifodase.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
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
    public RegistroDTO adicionar(RegistroForm form){
        Registro register = convertToRegistro(form ,Instant.now());
        Estoque estoque = estoqueRepository.findByName(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        item.setQtd(register.getQtd() + item.getQtd());
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return new RegistroDTO(register);
    }

    @Transactional
    public RegistroDTO retirar(RegistroDTO registerDTO) throws Exception {
        Registro register = new Registro(null, registerDTO.getNomeCanteiro(), registerDTO.getQtd(),
                registerDTO.getNomeItem(), registerDTO.getTipo(), Instant.now());
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
        return new RegistroDTO(register);
    }
    @Transactional
    public List<RegistroDTO> findAll(){
        List<Registro> list = registroRepository.findAll();
        return list.stream().map(x -> new RegistroDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<RegistroDTO> findByNomeCanteiro(String nomeCanteiro) {
        List<Registro> list = registroRepository.findByNomeCanteiro(nomeCanteiro);
        return list.stream().map(x -> new RegistroDTO(x)).collect(Collectors.toList());
    }

    private Registro convertToRegistro(RegistroForm form, Instant moment){
        Registro registro = new Registro();
        registro.setNomeCanteiro(form.getNomeCanteiro());
        registro.setNomeItem(form.getNomeItem());
        registro.setQtd(form.getQtd());
        registro.setMoment(moment);
    }


}
