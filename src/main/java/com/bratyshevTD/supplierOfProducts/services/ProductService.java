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

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {return productRepository.getReferenceById(id); }

    public List<Product> getAllProducts() {return productRepository.findAll(); }

    public Product getByTitle(String title) {return productRepository.findByTitle(title);}
}
