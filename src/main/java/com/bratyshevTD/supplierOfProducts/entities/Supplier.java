package com.bratyshevTD.supplierOfProducts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table (name = "supplier")
/*
 Поставщик
 @param id уникальный идентификатор продукции
 @param fullName ФИО поставщика
 @param phone телефон
 */
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
}
