package fis.finalTest.dto;

import fis.finalTest.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOrderItemDTO {
    private  Long orderId;
    private  Long productId;
    private Long quantity;
    public static class Mapper{
        public static AddOrderItemDTO fromEntity(OrderItem orderItem) {
            return AddOrderItemDTO.builder().orderId(orderItem.getId())
                    .productId(orderItem.getProduct().getId())
                    .quantity(orderItem.getQuantity())

                    .build();
        }
    }
}
