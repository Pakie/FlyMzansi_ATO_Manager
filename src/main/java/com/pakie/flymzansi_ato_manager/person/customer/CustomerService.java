package com.pakie.flymzansi_ato_manager.person.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long Id);
    void deleteCustomerById(Long Id);
}
