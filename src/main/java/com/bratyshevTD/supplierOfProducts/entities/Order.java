package com.bratyshevTD.supplierOfProducts.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "product_id")
    private Long productId;

}
