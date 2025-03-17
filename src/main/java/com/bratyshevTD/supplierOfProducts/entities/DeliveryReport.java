package com.bratyshevTD.supplierOfProducts.entities;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
    private long count;
    private long sum;
}
