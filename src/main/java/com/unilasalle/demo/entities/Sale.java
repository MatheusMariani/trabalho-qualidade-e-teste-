package com.unilasalle.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "SALES")
public class Sale {

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Customer customer;

}
