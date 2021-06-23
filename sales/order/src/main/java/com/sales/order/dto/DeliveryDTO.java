package com.sales.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DeliveryDTO {
    private boolean isAvailable;
    private LocalDate deliveryDate;
}
