package com.bratyshevTD.supplierOfProducts.controllers;

import com.bratyshevTD.supplierOfProducts.entities.Supplier;
import com.bratyshevTD.supplierOfProducts.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * Отображение страницы 'Поставщики'
     */
    @GetMapping("/supplier")
    public String supplierPage(Model model) {
        List<Supplier> supplierList = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", supplierList);
        return "suppliers";
    }

}
