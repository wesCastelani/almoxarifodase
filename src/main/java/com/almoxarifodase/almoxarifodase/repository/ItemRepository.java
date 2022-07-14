package com.almoxarifodase.almoxarifodase.repository;

import com.almoxarifodase.almoxarifodase.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String nomeItem);
}
