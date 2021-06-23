package com.sales.process.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventoryClient", url = "${inventoryClient.endpointUrl}")
public interface InventoryClient {
    @GetMapping(value = "inventory/check/product/{product-id}")
    ResponseEntity<Boolean> isProductAvailable(@PathVariable("product-id") String producId);
}
