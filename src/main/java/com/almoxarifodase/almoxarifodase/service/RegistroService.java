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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        Estoque estoque = estoqueRepository.findByNomeCanteiro(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        item.setQtd(register.getQtd() + item.getQtd());
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return convertToDTO(register);
    }

    @Transactional
    public RegistroDTO retirar(RegistroForm form) throws Exception {
        Registro register = convertToRegistro(form ,Instant.now());
        Estoque estoque = estoqueRepository.findByNomeCanteiro(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        if(item.getQtd() < register.getQtd()){
            throw new Exception();
        }else{
            Double itemAtual = item.getQtd() - register.getQtd();
            item.setQtd(itemAtual);
        }
        estoque.getItens().add(item);
        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return convertToDTO(register);
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
        registro.setTipo(form.getTipo());
        registro.setMoment(moment);
        return registro;
    }

    private RegistroDTO convertToDTO(Registro registro){
        return new RegistroDTO(registro);
    }


}
