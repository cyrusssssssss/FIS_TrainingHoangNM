package fis.finalTest.service.impl;

import fis.finalTest.dto.CustomerDTO;
import fis.finalTest.entity.Customer;
import fis.finalTest.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @Test
    void createCustomer() {
        Customer customer = Customer.builder()
                .name("Nguyen Minh Hoang")
                .address("Phu Xuyen Ha Noi")
                .mobile("0365478854")
                .build();
        customerService.createCustomer(customer);
        CustomerDTO c = customerService.findCustomerById(1L);
        assertEquals("Phu Xuyen Ha Noi",c.getAddress());
        assertEquals("0365478854",c.getMobile());
        assertEquals("Nguyen Minh Hoang",c.getName());
    }

    @Test
    void updateCustomer() {
        Customer customer = customerService.findById(1L);
        customer.setName("Nguyen Minh Vinh");
        customerService.updateCustomer(customer);
        Customer customer1 = customerService.findById(1L);
        assertEquals("Nguyen Minh Vinh",customer1.getName());
    }


    @Test
    void findAll() {
        Page<CustomerDTO> customerDTOs = customerService.findAll(PageRequest.of(0,4));
        assertEquals(4,customerDTOs.getSize());
    }

    @Test
    void findCustomerById() {
        CustomerDTO customerDTO = customerService.findCustomerById(1L);
        assertEquals("Phu Xuyen Ha Noi",customerDTO.getAddress());
        assertEquals("0365478854",customerDTO.getMobile());
        assertEquals("Ngo Thi Trieu",customerDTO.getName());
    }


}