package com.myleec.Itemh2.controllers;

import com.myleec.Itemh2.models.Item;
import com.myleec.Itemh2.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@GetMapping("/{id}")
	public Item getItemById(@PathVariable Long id) {
		return itemService.getItemById(id);
	}
	
	@PostMapping("/")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
	}
}
