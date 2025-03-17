package com.bratyshevTD.supplierOfProducts.services;

import com.bratyshevTD.supplierOfProducts.entities.Supplier;
import com.bratyshevTD.supplierOfProducts.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    /**
     * Получение поставщика по ФИО
     * @param fullName ФИО поставщика
     */
    public Supplier getByFullName(String fullName) { return supplierRepository.findByFullName(fullName); }

    /**
     * Получение всех поставщиков
     */
    public List<Supplier> getAllSuppliers() { return supplierRepository.findAll(); }

}
