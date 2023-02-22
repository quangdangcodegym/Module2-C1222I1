package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Customer findCustomerById(long idCustomer);
    void updateCustomer(long idCustomer, Customer customer);
}
