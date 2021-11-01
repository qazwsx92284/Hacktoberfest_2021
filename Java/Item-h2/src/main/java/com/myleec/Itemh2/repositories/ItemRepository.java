package com.myleec.Itemh2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myleec.Itemh2.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
