package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Supplier;
import com.bratyshevTD.supplierOfProducts.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public void setSupplierRepository(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier getSupplierById(Long id) { return supplierRepository.getReferenceById(id); }

    public Supplier getByFullName(String fullName) { return supplierRepository.findByFullName(fullName); }

    public List<Supplier> getAllSuppliers() { return supplierRepository.findAll(); }

}
