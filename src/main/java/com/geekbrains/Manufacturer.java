package com.geekbrains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "manufactures")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "title")
    private String title;

    @OneToMany(mappedBy = "manufacturer", cascade = {CascadeType.REMOVE})
    private List<Product> products;

    public Manufacturer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Product id = " + id + ", trademark = " + title;
    }
}
