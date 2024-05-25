package com.bratyshevTD.supplierOfProducts.controllers;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import com.bratyshevTD.supplierOfProducts.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeliveryController {

    DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/delivery")
    public String deliveryPage(Model model) {
        List<Delivery> deliveryList = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveryList);
        return "deliveries";
    }
}
