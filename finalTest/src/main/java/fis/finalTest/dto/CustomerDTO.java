package fis.finalTest.dto;

import fis.finalTest.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerDTO {
    private Long id;
    private String name;
    private String mobile;
    private String address;
    private String role;
    private String passWord;
    public static class Mapper{
        public static CustomerDTO fromEntity(Customer customer) {
            return CustomerDTO.builder().id(customer.getId())
                    .name(customer.getName())
                    .mobile(customer.getMobile())
                    .address(customer.getAddress())
                    .role(customer.getRole())
                    .passWord(customer.getPassWord())
                    .build();
        }
    }
}
