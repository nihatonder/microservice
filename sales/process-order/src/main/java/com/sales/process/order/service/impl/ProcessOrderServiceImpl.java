package com.sales.process.order.service.impl;

import com.sales.process.order.client.InventoryClient;
import com.sales.process.order.dto.DeliveryDTO;
import com.sales.process.order.service.ProcessOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {
    private final InventoryClient inventoryClient;

    public ProcessOrderServiceImpl(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public ResponseEntity<DeliveryDTO> calculateDeliveryDate(String productId) {
        Boolean isInStock = false;
        ResponseEntity<Boolean> response = null;

        try {
            response = inventoryClient.isProductAvailable(productId);

            if (response != null) {
                isInStock = response.getBody();
            }
        } catch (Exception exc) {
            throw new RuntimeException("Inventory service failed to reponse", exc);
        }

        DeliveryDTO deliveryDTO = new DeliveryDTO();
        if (isInStock) {
            deliveryDTO.setAvailable(true);
            int days = (int) (Math.random() * 7) + 1;
            deliveryDTO.setDeliveryDate(LocalDate.now().plusDays(days));
        }

        ResponseEntity<DeliveryDTO> responseEntity = new ResponseEntity<>(deliveryDTO, HttpStatus.OK);
        return responseEntity;
    }
}
