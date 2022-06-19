package vn.fis.training.ordermanagement.service.impl;

import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.Order;
import vn.fis.training.ordermanagement.domain.OrderItem;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.exception.NotFoundOrderException;
import vn.fis.training.ordermanagement.repository.OrderRepository;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addOrderItem(Long orderId, OrderItem orderItem) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()){
            throw new NotFoundOrderException( "Not found any order with this Id!");

        }

        else{
            order.get().getOrderItems().add(orderItem);
            order.get().setTotalAmount(order.get().getTotalAmount() + orderItem.getAmount() * orderItem.getQuantity());
            orderRepository.save(order.get());
        }
        return order.get();
    }

    @Override
    public Order removeOrderItem(Long orderId, OrderItem orderItem) {
        Optional<Order> order = orderRepository.findById(orderId);
        if(!order.isPresent()){
            throw new NotFoundOrderException( "Not found any order with this Id!");
        }
        else{
            order.get().getOrderItems().remove(orderItem);
            order.get().setTotalAmount(order.get().getTotalAmount() - orderItem.getAmount() * orderItem.getQuantity());
            orderRepository.save(order.get());
        }
        return order.get();
    }

    @Override
    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        Optional<Order> order1 = orderRepository.findById(order.getId());
        if(!order1.isPresent()){
            return null;
        }
        else{
            order1.get().setStatus(orderStatus);
            orderRepository.save(order1.get());
        }
        return order1.get();
    }

    @Override
    public List<Order> findOrdersBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        List<Order> list = orderRepository.findByOrderDateTimeBetween(fromDateTime, toDateTime);

        return list;
    }

    @Override
    public List<Order> findWaitingApprovalOrders() {

        return orderRepository.findByStatus(OrderStatus.WAITING_APPROVAL);
    }

    @Override
    public List<Order> findOrdersByOrderStatus(OrderStatus orderStatus) {
        List<Order> listOrder = orderRepository.findAllByStatus(orderStatus);
        return listOrder;
    }

    @Override
    public List<Order> findOrdersByCustomer(Customer customer) {
        List<Order> listOrder = orderRepository.findAllByCustomer(customer);
        return listOrder;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
