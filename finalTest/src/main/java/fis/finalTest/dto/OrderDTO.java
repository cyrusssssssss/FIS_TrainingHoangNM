package fis.finalTest.dto;

import fis.finalTest.entity.Order;
import fis.finalTest.entity.OrderItem;
import fis.finalTest.entity.OrderStatus;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private LocalDateTime orderDateTime;

    private Long customerId;

    private List<OrderItem> orderItems;

    private Double totalAmount;

    private OrderStatus status;

    public static class Mapper{
        public static  OrderDTO fromEntity(Order order) {
            return OrderDTO.builder().id(order.getId())
                     .orderDateTime(order.getOrderDateTime())
                    .orderItems(order.getOrderItems())
                    .customerId(order.getCustomer().getId())
                    .totalAmount(order.getTotalAmount())
                    .status(order.getStatus())
                    .build();
        }
    }
}
