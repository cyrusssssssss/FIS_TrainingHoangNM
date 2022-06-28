package fis.finalTest.service.impl;

import fis.finalTest.dto.*;
import fis.finalTest.entity.*;
import fis.finalTest.exception.FallStatusForUpdateException;
import fis.finalTest.exception.NotFoundCustomerException;
import fis.finalTest.exception.NotFoundOrderException;
import fis.finalTest.exception.NotFoundProductException;
import fis.finalTest.repository.CustomerRepository;
import fis.finalTest.repository.OrderRepository;
import fis.finalTest.repository.ProductRepository;
import fis.finalTest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAll(Pageable pageable) {
        log.info("Query all Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderRepository.findAll(pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<OrderDTO> findAllPaidOrders(Pageable pageable) {
        return orderRepository.findAllByStatus(OrderStatus.PAID, pageable).map(OrderDTO.Mapper::fromEntity);
    }

    @Override
    public OrderDTO findById(Long orderId) {
        return OrderDTO.Mapper.fromEntity(orderRepository.findById(orderId).orElseThrow(
                () -> {throw new IllegalArgumentException(String.format("Not found order with id %s",orderId));}));
    }

    @Override
    public Order addOrderItem(AddOrderItemDTO createOrderItemDTO) {
        Order order = orderRepository.findById(createOrderItemDTO.getOrderId()).orElseThrow(
                () -> new NotFoundOrderException("Order Not Found. Order Id " + createOrderItemDTO.getOrderId()));
        String status = String.valueOf(order.getStatus());
        if(status.equals("CREATED")) {
            Product product = productRepository.findById(createOrderItemDTO.getProductId()).orElseThrow(
                    () -> new NotFoundProductException("Product Not Found. Product Id " + createOrderItemDTO.getProductId()));
            OrderItem orderItem = OrderItem.builder().order(order).product(product).quantity(createOrderItemDTO.getQuantity()).amount(product.getPrice() * createOrderItemDTO.getQuantity()).build();

            order.getOrderItems().add(orderItem);

            order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item -> item.getAmount()).sum());
        }
        else{
            throw new FallStatusForUpdateException("Status not available update");
        }
        return order;
    }
    @Override
    public Order addOrder(CreateOrderDTO createOrderDTO) {
        Customer customer = customerRepository.findById(createOrderDTO.getCustomerId()).orElseThrow(
                () -> new NotFoundCustomerException("Customer Not Found. Order Id " + createOrderDTO.getCustomerId())
        );
        Order order = Order.builder().customer(customer).build();
        List<OrderItemDTO> listOrderItem = createOrderDTO.getOrderItems();
        listOrderItem.forEach(orderItem -> {
            Long productId = orderItem.getProductId();
            Product product = productRepository.findById(productId).orElseThrow(
                    () -> new NotFoundProductException("Product Not Found. Order Id "));
            Long soLuong = product.getAvailable();
            if(soLuong>0) {
                OrderItem orderItem1 = OrderItem.builder().order(order).product(product).
                        quantity(orderItem.getQuantity()).amount(product.getPrice() * orderItem.getQuantity()).build();
                order.getOrderItems().add(orderItem1);
                order.setTotalAmount(order.getOrderItems().stream().mapToDouble(item -> item.getAmount()).sum());
                product.setAvailable(soLuong-1);
                order.setStatus(OrderStatus.CREATED);
                orderRepository.save(order);
            }
            else {
                throw new FallStatusForUpdateException("Amount not available for update");
            }
        });
        return order;
    }

    @Override
    public Order deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(String.valueOf(order.getStatus()).equals("CREATE")||String.valueOf(order.getStatus()).equals("CANCELLED")){
            orderRepository.deleteById(orderId);
        }
        else {
            throw new FallStatusForUpdateException("Status not available for update");
        }
        return order;
    }

    @Override
    public Order removeOrderItem(RemoveItemDTO removeItemDTO) {
        Order order = orderRepository.findById(removeItemDTO.getOrderId()).get();
        order.getOrderItems().stream().forEach(orderItem -> {
            if(orderItem.getId().equals(removeItemDTO.getOrderItemId())){
                order.getOrderItems().remove(orderItem);
            }
            else{
                throw new FallStatusForUpdateException("Not found order item ");
            }
        });
        return order;
    }

    @Override
    public Order paid(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(String.valueOf(order.getStatus()).equals("CREATE")){
            order.setStatus(OrderStatus.valueOf("PAID"));
        }
        else{
            throw new FallStatusForUpdateException("Status not available update");
        }
        return order;
    }

    @Override
    public Order cancel(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        if(String.valueOf(order.getStatus()).equals("CREATE")){
            order.setStatus(OrderStatus.valueOf("CANCELLED"));
        }
        else{
            throw new FallStatusForUpdateException("Status not available update");
        }
        return order;
    }


}
