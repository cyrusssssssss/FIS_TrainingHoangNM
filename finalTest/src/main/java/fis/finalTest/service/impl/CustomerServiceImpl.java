package fis.finalTest.service.impl;

import fis.finalTest.dto.CustomerDTO;
import fis.finalTest.entity.Customer;
import fis.finalTest.exception.NotFoundCustomerException;
import fis.finalTest.repository.CustomerRepository;
import fis.finalTest.repository.ProductRepository;
import fis.finalTest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CustomerDTO> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).map(CustomerDTO.Mapper::fromEntity);
    }

    @Override
    public CustomerDTO findCustomerById(Long customerId) {
        CustomerDTO customerDTO= customerRepository.findById(customerId).map(CustomerDTO.Mapper::fromEntity).orElseThrow(
                () -> new NotFoundCustomerException("Customer Not Found. Order Id " + customerId
        ));
        return customerDTO;
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }


}
