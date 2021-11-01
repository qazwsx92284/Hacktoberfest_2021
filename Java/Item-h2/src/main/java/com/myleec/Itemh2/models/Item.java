package com.myleec.Itemh2.models;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long item_id;
	private String item_name;
	private Double price;
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Item() {
		
	}
	
	
	public Item(Long id, String name, Double price, Integer quantity) {
		super();
		this.item_id = id;
		this.item_name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return item_id;
	}
	public void setId(Long id) {
		this.item_id = id;
	}
	public String getName() {
		return item_name;
	}
	public void setName(String name) {
		this.item_name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
