package com.pakie.flymzansi_ato_manager.person.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optional = customerRepo.findById(id);
        Customer customer = null;
        if (optional.isPresent()){
            customer = optional.get();
        } else {
            throw new RuntimeException("The customer with ID " + id + " does not exist");
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerRepo.deleteById(id);
    }
}
