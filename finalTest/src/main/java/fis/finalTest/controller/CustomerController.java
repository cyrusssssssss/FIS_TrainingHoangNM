package fis.finalTest.controller;

import fis.finalTest.dto.CustomerDTO;
import fis.finalTest.dto.OrderDTO;
import fis.finalTest.entity.Customer;
import fis.finalTest.service.CustomerService;
import fis.finalTest.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@PreAuthorize("hasRole('ROLE_CUSTOMER')")
@Slf4j
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<CustomerDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize) {

        return customerService.findAll(PageRequest.of(pageNumber, pageSize));
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findAllById(@PathVariable(name="customerId") Long customerId) {
        return new ResponseEntity<>(customerService.findCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping("/huhu")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {

        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);

    }
    @PostMapping("/{customerId}/{mobile}/{address}")
    public ResponseEntity<Customer> update(@PathVariable(name="customerId") Long customerId,@PathVariable(name="mobile") String mobile,@PathVariable(name="address") String address) {
        Customer customer = customerService.findById(customerId);
        customer.setMobile(mobile);
        customer.setAddress(address);
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);

    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> delete(@PathVariable(name="customerId") Long customerId) {
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>( HttpStatus.OK);

    }

}
