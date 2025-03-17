package com.bratyshevTD.supplierOfProducts.exceptions;

/**
 * Ошибка, возникающая в случае, если дата начала позже даты окончания
 */
public class InvalidDateIntervalException extends RuntimeException {
    public InvalidDateIntervalException(String message) {
        super(message);
    }

    public InvalidDateIntervalException() {
        super("Неверный диапазон дат. Проверьте, чтобы дата начала была раньше даты окончания");
    }
}
