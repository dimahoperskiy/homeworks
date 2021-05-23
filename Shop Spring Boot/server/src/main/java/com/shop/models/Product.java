package com.shop.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;
    private Integer amount;
    private Integer price;
    private String vendorCode;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @Column(insertable = false, updatable = false)
    private Long model_id;
}
