package com.bratyshevTD.supplierOfProducts.repositories;

import com.bratyshevTD.supplierOfProducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByTitle(String title);
}
