package com.myleec.Itemh2.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long manufacturer_id;
    private String manufacturer_name;
    private String location;

    @OneToMany(mappedBy = "manufacturer")
    @Column(name="items")
    private List<Item> items;

    public Manufacturer() {

    }

    public Manufacturer(Long manufacturer_id, String manufacturer_name, String location, List<Item> items) {
        this.manufacturer_id = manufacturer_id;
        this.manufacturer_name = manufacturer_name;
        this.location = location;
        this.items = items;
    }
}
