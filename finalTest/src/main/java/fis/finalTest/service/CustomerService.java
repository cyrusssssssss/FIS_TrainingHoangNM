package fis.finalTest.service;



import fis.finalTest.dto.CustomerDTO;
import fis.finalTest.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long customerId);
    Page<CustomerDTO> findAll(Pageable pageable);
    CustomerDTO findCustomerById(Long customerId);
    Customer findById(Long customerId);



}
