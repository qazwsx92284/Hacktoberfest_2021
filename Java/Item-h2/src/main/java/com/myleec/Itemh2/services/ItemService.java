package com.myleec.Itemh2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myleec.Itemh2.models.Item;
import com.myleec.Itemh2.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	

	public Item getItemById(Long id) {
		return itemRepository.getById(id);
	}
	
	public Item addItem(Item item) {
		return itemRepository.saveAndFlush(item);
	}

	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
	 
}
