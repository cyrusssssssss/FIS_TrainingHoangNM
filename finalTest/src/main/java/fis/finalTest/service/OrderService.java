package fis.finalTest.service;

import fis.finalTest.dto.CreateOrderDTO;
import fis.finalTest.dto.AddOrderItemDTO;
import fis.finalTest.dto.OrderDTO;
import fis.finalTest.dto.RemoveItemDTO;
import fis.finalTest.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    Page<OrderDTO> findAllPaidOrders(Pageable pageable);

    OrderDTO findById(Long orderId);
    Order addOrderItem(AddOrderItemDTO createOrderItemDTO);
    Order addOrder(CreateOrderDTO createOrderDTO);
    Order deleteOrder(Long orderId);
    Order removeOrderItem(RemoveItemDTO removeItemDTO);
    Order paid(Long orderId);
    Order cancel(Long orderId);
}
