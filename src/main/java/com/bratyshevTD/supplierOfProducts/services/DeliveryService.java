package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import com.bratyshevTD.supplierOfProducts.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryService {


    private DeliveryRepository deliveryRepository;

    @Autowired
    public void setDeliveryRepository(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

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
