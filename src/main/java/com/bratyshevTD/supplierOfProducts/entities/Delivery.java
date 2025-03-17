package com.bratyshevTD.supplierOfProducts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "delivery")
/*
  Заказ
  @param id уникальный идентификатор заказа
  @param supplierId идентификатор поставщика
  @param Дата заказа
 */
public class Delivery {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Supplier supplierId;
    private LocalDate date;

    public Delivery(Supplier supplierId, LocalDate date) {
        this.supplierId = supplierId;
        this.date = date;
    }
}
