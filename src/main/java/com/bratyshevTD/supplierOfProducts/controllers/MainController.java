package com.bratyshevTD.supplierOfProducts.controllers;

import com.bratyshevTD.supplierOfProducts.entities.*;
import com.bratyshevTD.supplierOfProducts.services.DeliveryProductService;
import com.bratyshevTD.supplierOfProducts.services.DeliveryService;
import com.bratyshevTD.supplierOfProducts.services.ProductService;
import com.bratyshevTD.supplierOfProducts.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class MainController {


    private DeliveryService deliveryService;
    private ProductService productService;
    private SupplierService supplierService;
    private DeliveryProductService deliveryProductService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Autowired
    public void setDeliveryProductService(DeliveryProductService deliveryProductService) {
        this.deliveryProductService = deliveryProductService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @PostMapping("/delivery-accept")
    public String deliveryAccept(Model model, @RequestParam Long deliveryId, @RequestParam String supplier, @RequestParam LocalDate date,
                                 @RequestParam(required = false) String product1, @RequestParam(required = false) Integer count1, @RequestParam(required = false) Integer price1,
                                 @RequestParam(required = false) String product2, @RequestParam(required = false) Integer count2, @RequestParam(required = false) Integer price2,
                                 @RequestParam(required = false) String product3, @RequestParam(required = false) Integer count3, @RequestParam(required = false) Integer price3,
                                 @RequestParam(required = false) String product4, @RequestParam(required = false) Integer count4, @RequestParam(required = false) Integer price4)

    {

        if ((product1.isEmpty() && product2.isEmpty() && product3.isEmpty() && product4.isEmpty())
                || (deliveryId.equals(null) && supplier.isEmpty() && date.equals(null))){
            return "redirect:";
        }

        Delivery delivery = new Delivery(deliveryId, supplierService.getByFullName(supplier), date);
        deliveryService.addDelivery(delivery);

        if (!product1.isEmpty()) {
            DeliveryProduct deliveryProduct = new DeliveryProduct(deliveryService.getById(deliveryId), productService.getByTitle(product1), count1, price1);
            deliveryProductService.addDeliveryProduct(deliveryProduct);
        }
        if (!product2.isEmpty()) {
            DeliveryProduct deliveryProduct = new DeliveryProduct(deliveryService.getById(deliveryId), productService.getByTitle(product2), count2, price2);
            deliveryProductService.addDeliveryProduct(deliveryProduct);
        }
        if (!product3.isEmpty()) {
            DeliveryProduct deliveryProduct = new DeliveryProduct(deliveryService.getById(deliveryId), productService.getByTitle(product3), count3, price3);
            deliveryProductService.addDeliveryProduct(deliveryProduct);
        }
        if (!product4.isEmpty()) {
            DeliveryProduct deliveryProduct = new DeliveryProduct(deliveryService.getById(deliveryId), productService.getByTitle(product4), count4, price4);
            deliveryProductService.addDeliveryProduct(deliveryProduct);
        }
        return "delivery-accept";

    }

    @GetMapping("/delivery-report")
    public String deliveryReport(Model model, @RequestParam LocalDate dateFrom, @RequestParam LocalDate dateTo) {
        List<DeliveryReport> deliveryReportList = deliveryProductService.report(dateFrom, dateTo);
        model.addAttribute("reports", deliveryReportList);
        return "delivery-report";
    }
}
