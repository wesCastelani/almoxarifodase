package com.almoxarifodase.almoxarifodase.service;

import com.almoxarifodase.almoxarifodase.model.DTO.RegistroDTO;
import com.almoxarifodase.almoxarifodase.model.entities.Estoque;
import com.almoxarifodase.almoxarifodase.model.entities.Item;
import com.almoxarifodase.almoxarifodase.model.entities.ItemEstoque;
import com.almoxarifodase.almoxarifodase.model.entities.Registro;
import com.almoxarifodase.almoxarifodase.model.forms.RegistroForm;
import com.almoxarifodase.almoxarifodase.repository.EstoqueRepository;
import com.almoxarifodase.almoxarifodase.repository.ItemEstoqueRepository;
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

    @Autowired
    ItemEstoqueRepository itemEstoqueRepository;

    @Transactional
    public RegistroDTO adicionar(RegistroForm form){
        Registro register = convertToRegistro(form ,Instant.now());
        Estoque estoque = estoqueRepository.findByNomeCanteiro(register.getNomeCanteiro());
        Item item = itemRepository.findByName(register.getNomeItem());
        if(estoque.getItensEmEstoque().isEmpty()){
            ItemEstoque itens = new ItemEstoque(item, form.getQtd());
            estoque.getItensEmEstoque().add(itens);
            itemEstoqueRepository.save(itens);
        }else {
            estoque.getItensEmEstoque().forEach(i -> {
                if (i.getItem().getName().equals(form.getNomeItem())) {
                    i.setQtd(i.getQtd() + form.getQtd());
                } else {
                    ItemEstoque itens = new ItemEstoque(item, form.getQtd());
                    estoque.getItensEmEstoque().add(itens);
                    itemEstoqueRepository.save(itens);
                }
            });
        }

        estoqueRepository.save(estoque);
        registroRepository.save(register);
        return convertToDTO(register);
    }

    @Transactional
    public RegistroDTO retirar(RegistroForm form) throws Exception {
        Registro register = convertToRegistro(form ,Instant.now());
        Estoque estoque = estoqueRepository.findByNomeCanteiro(register.getNomeCanteiro());
        estoque.getItensEmEstoque().forEach(i -> {
            if (i.getItem().getName().equals(register.getNomeItem())){
                if(i.getQtd() >= register.getQtd()){
                    i.setQtd(i.getQtd() - register.getQtd());
                }else{
                    throw new RuntimeException();
                }
            }
        });
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
