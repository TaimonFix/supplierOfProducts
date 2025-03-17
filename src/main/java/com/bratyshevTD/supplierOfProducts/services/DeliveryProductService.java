package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.DeliveryProduct;
import com.bratyshevTD.supplierOfProducts.entities.DeliveryReport;
import com.bratyshevTD.supplierOfProducts.repositories.DeliveryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryProductService {

    private final DeliveryProductRepository deliveryProductRepository;

    /**
     * Добавление продукции из заказа
     */
    public void addDeliveryProduct(DeliveryProduct deliveryProduct) { deliveryProductRepository.save(deliveryProduct); }

    /**
     * Получение отчета за определенный период
     * @param dateFrom дата начала
     * @param dateTo дата окончания
     */
    public List<DeliveryReport> report(LocalDate dateFrom, LocalDate dateTo) {
        System.out.println(deliveryProductRepository.report(dateFrom, dateTo));
        return deliveryProductRepository.report(dateFrom, dateTo); }
}
