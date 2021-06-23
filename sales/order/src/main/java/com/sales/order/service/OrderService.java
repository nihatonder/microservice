package com.sales.order.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public interface OrderService {
    @GetMapping(value = "/deliveryInformation/{product-id}")
    ResponseEntity<String> getDeliveryInformation(@PathVariable("product-id") String productId);
}
