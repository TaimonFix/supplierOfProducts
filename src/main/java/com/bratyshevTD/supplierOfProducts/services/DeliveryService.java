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

    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    public Delivery getById(Long id) { return deliveryRepository.getReferenceById(id); }
    public List<Delivery> getAllDeliveries() { return deliveryRepository.findAll(); }




}
