package fis.finalTest.repository;

import fis.finalTest.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    void Create() {
        Customer customer = Customer.builder().id(4L).name("Nguyen Minh Hoang").mobile("0365478854").address("Phu Xuyen - Ha Noi").build();
        customerRepository.save(customer);
        List<Customer> customerList = customerRepository.findAll();
        assertEquals(3,customerList.size());

    }
    @Test
    void delete() {
        customerRepository.deleteById(2L);
        List<Customer> customerList = customerRepository.findAll();
        assertEquals(3,customerList.size());

    }
    @Test
    void update() {
        Customer customer = Customer.builder().id(4L).name("Nguyen Minh Hoang").mobile("0365478854").address("Phu Xuyen - Ha Noi").build();
        customer.setName("Ngo Thi Trieu");
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getId()).get();
        assertEquals("Ngo Thi Trieu",customer1.getName());
    }
}