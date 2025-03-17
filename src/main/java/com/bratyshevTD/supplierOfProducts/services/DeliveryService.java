package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import com.bratyshevTD.supplierOfProducts.repositories.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    /**
     * Добавление заказа
     */
    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    /**
     * Поиск заказа по id
     * @param id идентификатор заказа
     */
    public Delivery getById(Long id) { return deliveryRepository.getReferenceById(id); }

    /**
     * Получение всех заказов
     */
    public List<Delivery> getAllDeliveries() { return deliveryRepository.findAll(); }




}
