package com.codegym.service.file;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FCustomerService implements ICustomerService {
    private final String pathCustomer = "./data/customer.csv";
    @Override
    public List<Customer> getAllCustomers() {
        return FileUtils.readDataFromFile(pathCustomer, Customer.class);
    }

    @Override
    public Customer findCustomerById(long idCustomer) {
                    List<Customer> customers = getAllCustomers();
                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getId() == idCustomer) {
                            return customers.get(i);
                        }
                    }
        return null;
    }

    @Override
    public void updateCustomer(long idCustomer, Customer customer) {
        List<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomer) {
                customers.get(i).setName(customer.getName());
                customers.get(i).setAddress(customer.getAddress());
                customers.get(i).setConsumed(customer.getConsumed());
                customers.get(i).setCreateAt(customer.getCreateAt());
                customers.get(i).setPhone(customer.getPhone());
                customers.get(i).setCustomerType(customer.getCustomerType());
            }
        }
        FileUtils.writeDataToFile(pathCustomer, customers);


    }

    @Override
    public void addCustomer(Customer customer) {
        List<Customer> customers = getAllCustomers();
        long lastId = 1;
        if(customers.size()!=0){
            Customer lastCustomer = customers.get(customers.size()-1);
            lastId = lastCustomer.getId()+1;
        }
        customer.setId(lastId);
        customers.add(customer);

        FileUtils.writeDataToFile(pathCustomer, customers);
    }
}
