package com.bratyshevTD.supplierOfProducts.repositories;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Query("SELECT d FROM Delivery d WHERE d.date BETWEEN :dateFrom AND :dateTo")
    List<Delivery> report(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
