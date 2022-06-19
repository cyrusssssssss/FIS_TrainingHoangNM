package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.service.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @Test
    void createCustomer() {
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setMobile("34");
        customer.setAddress("1");
        customer.setName("huh");
        customerService.createCustomer(customer);
        int count = customerService.findAll().size();
        assertEquals(2, count);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setMobile("34");
        customer.setAddress("1");
        customer.setName("huh");
        System.out.println(customerService.updateCustomer(customer));
    }

    @Test
    void deleteCustomerById() {
        customerService.deleteCustomerById(2L);
        int count = customerService.findAll().size();
        assertEquals(1, count);
    }

    @Test
    void findAll() {
        int count = customerService.findAll().size();
        assertEquals(2, count);
    }

    @Test
    void findByMobileNumber() {
        String phone = customerService.findByMobileNumber("123").getMobile();
        assertEquals("123", phone);
    }
}