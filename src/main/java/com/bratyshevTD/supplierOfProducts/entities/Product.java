package com.bratyshevTD.supplierOfProducts.entities;


import jakarta.persistence.*;

@Entity
@Table (name = "product")
/*
 Продукция
 @param id уникальный идентификатор продукции
 @param title название
 */
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Product() {
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
}
