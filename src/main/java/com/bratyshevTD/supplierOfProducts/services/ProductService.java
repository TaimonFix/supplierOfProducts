package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Product;
import com.bratyshevTD.supplierOfProducts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Получение продукции по названию
     */
    public Product getByTitle(String title) {return productRepository.findByTitle(title);}

    /**
     * Получение всей продукции
     */
    public List<Product> getAllProducts() {return productRepository.findAll(); }
}
