package com.sales.order.client;

import com.sales.order.dto.DeliveryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "processOrderClient", url = "${processOrderClient.endpointUrl}")
public interface ProcessOrderClient {
    @GetMapping(value = "process-order/delivery/{product-id}")
    ResponseEntity<DeliveryDTO> calculateDeliveryDate(@PathVariable("product-id") String producId);
}
