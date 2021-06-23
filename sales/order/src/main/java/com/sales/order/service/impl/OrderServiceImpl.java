package com.sales.order.service.impl;

import com.sales.order.client.ProcessOrderClient;
import com.sales.order.dto.DeliveryDTO;
import com.sales.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final ProcessOrderClient processOrderClient;

    public OrderServiceImpl(ProcessOrderClient processOrderClient) {
        this.processOrderClient = processOrderClient;
    }

    @Override
    public ResponseEntity<String> getDeliveryInformation(String productId) {
        ResponseEntity<DeliveryDTO> response = null;
        DeliveryDTO deliveryDTO = null;
        String result = "Product not available";

        try {
            response = processOrderClient.calculateDeliveryDate(productId);
        } catch (Exception exc) {
            throw new RuntimeException("Process Order service failed to response", exc);
        }

        if(response != null) {
            deliveryDTO = response.getBody();
            if (deliveryDTO.isAvailable()) {
                result = "Will be delivered on " + deliveryDTO.getDeliveryDate();
            }
        }
        ResponseEntity<String> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
        return responseEntity;
    }
}
