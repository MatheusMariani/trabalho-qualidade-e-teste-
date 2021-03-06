package com.unilasalle.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {


    @Id
    private Long Id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "PRICE", nullable = false)
    private double price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
