package fis.finalTest.dto;

import fis.finalTest.entity.Order;
import fis.finalTest.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderDTO {
    private  Long customerId;
    private List<OrderItemDTO> orderItems;
    
}
