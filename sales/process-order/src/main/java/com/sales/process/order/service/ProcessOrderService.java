package com.sales.process.order.service;

import com.sales.process.order.dto.DeliveryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process-order")
public interface ProcessOrderService {
    @GetMapping(value = "/delivery/{product-id}")
    ResponseEntity<DeliveryDTO> calculateDeliveryDate(@PathVariable("product-id") String productId);
}
