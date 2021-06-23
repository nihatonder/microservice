package com.sales.inventory.service.impl;

import com.sales.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public ResponseEntity<Boolean> isProductAvailable(String productId) {
        int num = (int) (Math.random() * 2);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(num == 1, HttpStatus.OK);
        return responseEntity;
    }
}
