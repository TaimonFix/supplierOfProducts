package com.bratyshevTD.supplierOfProducts.entities;

import com.bratyshevTD.supplierOfProducts.controllers.ProductController;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "deliveries_products")
public class DeliveryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery deliveryId;


    @ManyToOne  (fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    private int count;

    private int price;

    public DeliveryProduct(Delivery deliveryId, Product productId, int count, int price) {
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

    public DeliveryProduct() {
    }

    public Delivery getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Delivery deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
