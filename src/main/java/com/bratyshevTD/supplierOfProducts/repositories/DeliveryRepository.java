package com.bratyshevTD.supplierOfProducts.repositories;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import com.bratyshevTD.supplierOfProducts.entities.DeliveryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
