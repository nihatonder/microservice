package com.sales.inventory.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public interface InventoryService {
    @GetMapping(value = "/check/product/{product-id}")
    ResponseEntity<Boolean> isProductAvailable(@PathVariable("product-id") String productId);
}
