package com.bratyshevTD.supplierOfProducts.repositories;

import com.bratyshevTD.supplierOfProducts.entities.Delivery;
import com.bratyshevTD.supplierOfProducts.entities.DeliveryProduct;
import com.bratyshevTD.supplierOfProducts.entities.DeliveryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryProductRepository extends JpaRepository<DeliveryProduct, Long> {

    @Query("SELECT new com.bratyshevTD.supplierOfProducts.entities.DeliveryReport(d.supplierId, dp.productId, SUM(dp.count), SUM(dp.count * dp.price)) " +
            "FROM Delivery d " +
            "JOIN DeliveryProduct dp ON d.id = deliveryId.id " +
            "WHERE (d.date BETWEEN :dateFrom AND :dateTo) " +
            " GROUP BY d.supplierId, dp.productId"
    )
    List<DeliveryReport> report(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}

