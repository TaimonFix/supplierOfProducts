package com.bratyshevTD.supplierOfProducts.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/*
 Класс для формирования отчета
 @param supplierId идентификатор поставщика
 @param productId идентификатор продукта
 @param count количество продукции
 @param sum суммарная цена всей поступившей продукции
 */
public class DeliveryReport {

    private Supplier supplierId;
    private Product productId;
    private Long count;
    private Long sum;
}
