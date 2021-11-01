package com.myleec.Itemh2.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customer_id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "customer")
    @Column(name="items")
    private List<Item> items;

    public Customer() {

    }

    public Customer(Long customer_id, String username, String password) {
        this.customer_id = customer_id;
        this.username = username;
        this.password = password;
    }



    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
