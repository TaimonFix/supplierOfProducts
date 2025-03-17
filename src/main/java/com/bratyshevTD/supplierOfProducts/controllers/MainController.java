package com.bratyshevTD.supplierOfProducts.controllers;

import com.bratyshevTD.supplierOfProducts.entities.*;
import com.bratyshevTD.supplierOfProducts.exceptions.InvalidDateIntervalException;
import com.bratyshevTD.supplierOfProducts.services.DeliveryProductService;
import com.bratyshevTD.supplierOfProducts.services.DeliveryService;
import com.bratyshevTD.supplierOfProducts.services.ProductService;
import com.bratyshevTD.supplierOfProducts.services.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final DeliveryService deliveryService;
    private final ProductService productService;
    private final SupplierService supplierService;
    private final DeliveryProductService deliveryProductService;

    /**
     * Отображение главной страницы
     */
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    /**
     * Добавление информации о заказе в БД
     * @param model для передачи параметров в .html
     * @param supplier ФИО поставщика
     * @param date дата заказа
     * @param product1 название продукции
     * @param count1 количество
     * @param price1 стоимость
     * @throws NullPointerException при незаполненных полях 'ФИО', 'Дата'. 'Продукция','Количество','Стоимость'
     */
    @PostMapping("/delivery-accept")
    public String deliveryAccept(Model model, @RequestParam(required = false) String supplier, @RequestParam(required = false) LocalDate date,
                                 @RequestParam(required = false) String product1, @RequestParam(required = false) Integer count1, @RequestParam(required = false) Integer price1,
                                 @RequestParam(required = false) String product2, @RequestParam(required = false) Integer count2, @RequestParam(required = false) Integer price2,
                                 @RequestParam(required = false) String product3, @RequestParam(required = false) Integer count3, @RequestParam(required = false) Integer price3,
                                 @RequestParam(required = false) String product4, @RequestParam(required = false) Integer count4, @RequestParam(required = false) Integer price4) {
        try {
            if (supplier.isEmpty()) {
                throw new NullPointerException("Введите ФИО из таблицы Поставщики.");
            }
            if (supplierService.getByFullName(supplier) == null) {
                throw new NullPointerException("ФИО '" + supplier + "' отсутствует в БД. " +
                        "Введите ФИО из таблицы Поставщики.");
            }
            if (date == null) {
                throw new NullPointerException("Введите дату поставки.");
            }
            if ((product1.isEmpty() && product2.isEmpty() && product3.isEmpty() && product4.isEmpty())) {
                return "redirect:";
            }

            Delivery delivery = new Delivery(supplierService.getByFullName(supplier), date);
            Long deliveryId = (deliveryService.addDelivery(delivery)).getId();

            if (!product1.isEmpty()) {
                addDeliveryProduct(deliveryId, product1, count1, price1);
            }
            if (!product2.isEmpty()) {
                addDeliveryProduct(deliveryId, product2, count2, price2);
            }
            if (!product3.isEmpty()) {
                addDeliveryProduct(deliveryId, product3, count3, price3);
            }
            if (!product4.isEmpty()) {
                addDeliveryProduct(deliveryId, product4, count4, price4);
            }
            return "delivery-accept";
        } catch (NullPointerException e) {
            model.addAttribute("exceptionInput", e.getMessage());
            return "index";
        }
    }

    /**
     * Добавление продукции из заказа в БД
     * @param deliveryId индентификатор поставщика
     * @param product название продукции
     * @param count количество продукции
     * @param price цена за единицу
     */
    private void addDeliveryProduct(Long deliveryId, String product, Integer count, Integer price) {
        if (count == null) {
            throw new NullPointerException("Заполните количество для продукции '" + product + "'.");
        }
        if (price == null) {
            throw new NullPointerException("Заполните цену для продукции '" + product + "'.");
        }
        if (productService.getByTitle(product) == null) {
            throw new NullPointerException("Продукт '" + product + "' отсутствует в БД. " +
                    "Введите название продукта из таблицы Продукты.");
        }
        deliveryProductService.addDeliveryProduct(
                new DeliveryProduct(deliveryService.getById(deliveryId),
                        productService.getByTitle(product), count, price));
    }

    /**
     * Формирование отчета за определенный период
     * @param model для передачи параметров в .html
     * @param dateFrom дата начала интервала
     * @param dateTo окончания интервала
     * @throws NullPointerException при незаполненных полях 'Дата начала','Дата окончания'.
     * @throws InvalidDateIntervalException в случае, если дата начала позже даты окончания.
     */
    @GetMapping("/delivery-report")
    public String deliveryReport(Model model, @RequestParam(required = false) LocalDate dateFrom, @RequestParam(required = false) LocalDate dateTo) {
        try {
            if (dateFrom == null) {
                throw new NullPointerException("Введите дату начала интервала.");
            }
            if (dateTo == null) {
                throw new NullPointerException("Введите дату окончания интервала.");
            }
            if (dateFrom.isAfter(dateTo)) {
                throw new InvalidDateIntervalException();
            }
            List<DeliveryReport> deliveryReportList = deliveryProductService.report(dateFrom, dateTo);
            model.addAttribute("reports", deliveryReportList);
            model.addAttribute("dateFrom", dateFrom.format(Delivery.DATE_FORMATTER));
            model.addAttribute("dateTo", dateTo.format(Delivery.DATE_FORMATTER));

            return "delivery-report";
        } catch (NullPointerException | InvalidDateIntervalException e) {
            model.addAttribute("exceptionReport", e.getMessage());
            return "index";
        }
    }
}
