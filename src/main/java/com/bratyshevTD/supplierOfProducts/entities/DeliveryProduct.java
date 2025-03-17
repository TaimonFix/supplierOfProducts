package com.bratyshevTD.supplierOfProducts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "deliveries_products")
/*
 Промежуточная таблица между сущностями 'delivery','product' для устранения связи 'многие-ко-многим'
 @param id уникальный идентификатор
 @param deliveryId идентификатор заказа
 @param productId идентификатор продукта
 @param count количество продукции
 @param price цена за единицу
 */
public class DeliveryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery deliveryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;
    private Integer count;
    private Integer price;

    public DeliveryProduct(Delivery deliveryId, Product productId, Integer count, Integer price) {
        this.deliveryId = deliveryId;
        this.productId = productId;
        this.count = count;
        this.price = price;
    }
}
