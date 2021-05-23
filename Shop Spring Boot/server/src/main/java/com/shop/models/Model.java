package com.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Column(insertable = false, updatable = false)
    private Long country_id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @Column(insertable = false, updatable = false)
    private Long manufacturer_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();
}
