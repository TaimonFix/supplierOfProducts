package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Product;
import com.bratyshevTD.supplierOfProducts.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Получение продукции по названию
     */
    public Product getByTitle(String title) {return productRepository.findByTitle(title);}

    /**
     * Получение всей продукции
     */
    public List<Product> getAllProducts() {return productRepository.findAll(); }
}
