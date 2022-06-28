package fis.finalTest.repository;

import fis.finalTest.entity.Customer;
import fis.finalTest.entity.Order;
import fis.finalTest.entity.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;
    @Test
    void Create() {
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .totalAmount(1000.0)
                .build();
        orderRepository.save(order);
        List<Order> orderList = orderRepository.findAll();
        assertEquals(3,orderList.size());

    }
    @Test
    void delete() {
        orderRepository.deleteById(2L);
        List<Order> orderList = orderRepository.findAll();
        assertEquals(3,orderList.size());

    }
    @Test
    void update() {
        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .status(OrderStatus.CREATED)
                .totalAmount(1000.0)
                .build();
        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
        Order order1 = orderRepository.findById(order.getId()).get();
        assertEquals("PAID",order1.getStatus().toString());
    }
}