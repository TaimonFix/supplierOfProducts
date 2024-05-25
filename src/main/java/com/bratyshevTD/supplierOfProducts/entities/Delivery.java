package com.bratyshevTD.supplierOfProducts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Supplier supplierId;

    private LocalDate date;

//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "deliveries_products",
//            joinColumns = @JoinColumn(name = "delivery_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> productList;

    public Delivery(Long id, Supplier supplierId, LocalDate date) {
        this.id = id;
        this.supplierId = supplierId;
        this.date = date;

    }

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
