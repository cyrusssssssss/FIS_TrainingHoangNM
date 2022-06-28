package fis.finalTest.service.impl;

import fis.finalTest.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    void addOrderItem() {
        AddOrderItemDTO addOrderItemDTO = AddOrderItemDTO.builder()
                .orderId(1L)
                .productId(1L)
                .quantity(1L)
                .build();
        orderService.addOrderItem(addOrderItemDTO);

        OrderDTO orderDTO = orderService.findById(1L);

        assertEquals(100,orderDTO.getTotalAmount());
    }

    @Test
    void addOrder() {
        OrderItemDTO o1 = OrderItemDTO.builder()
                .productId(1L)
                .quantity(2L)
                .build();
        OrderItemDTO o2 = OrderItemDTO.builder()
                .productId(2L)
                .quantity(3L)
                .build();

        CreateOrderDTO createOrderDTO = CreateOrderDTO.builder()
                .customerId(3L)
                .orderItems(new ArrayList<>(Arrays.asList(o1,o2)))
                .build();
        orderService.addOrder(createOrderDTO);

        OrderDTO orderDTO = orderService.findById(3L);
        assertEquals(200,orderDTO.getTotalAmount());
    }

    @Test
    void removeOrderItem() {
        RemoveItemDTO removeItemDTO = RemoveItemDTO.builder()
                .orderId(1L)
                .orderItemId(5L)
                .build();
        orderService.removeOrderItem(removeItemDTO);
        OrderDTO orderDTO = orderService.findById(1L);
        assertEquals(50,orderDTO.getTotalAmount());
    }
}