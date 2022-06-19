package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @BeforeEach
    void init(){

    }
    @Test
    void createOrder() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setMobile("34");
        customer.setAddress("1");
        customer.setName("huh");

        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmount(12D);
        order.setCustomer(customer);
        orderService.createOrder(order);

        int count = orderService.findAll().size();

        assertEquals(2, count);
    }

    @Test
    void addOrderItem() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setMobile("34");
        customer.setAddress("1");
        customer.setName("huh");

        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmount(12D);
        order.setCustomer(customer);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setId(1L);
        orderItem.setQuantity(Integer.parseInt("1"));
        orderItem.setAmount(123D);

        orderService.addOrderItem(1L, orderItem);

    }

    @Test
    void removeOrderItem() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setMobile("34");
        customer.setAddress("1");
        customer.setName("huh");

        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.CREATED);
        order.setTotalAmount(12D);
        order.setCustomer(customer);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setId(1L);
        orderItem.setQuantity(Integer.parseInt("1"));
        orderItem.setAmount(123D);

        orderService.removeOrderItem(1L, orderItem);
    }

    @Test
    void updateOrderStatus() {

    }

    @Test
    void findOrdersBetween() {
        String str = "2022-05-04 11:30:40";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        String str1 = "2022-07-04 11:30:40";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1 = LocalDateTime.parse(str, formatter);

        int count = orderService.findOrdersBetween(dateTime, dateTime1).size();
        assertEquals(2, count);
    }

    @Test
    void findWaitingApprovalOrders() {
    }

    @Test
    void findOrdersByOrderStatus() {
    }

    @Test
    void findOrdersByCustomer() {
    }
}