/**
package com.codegym.service.inmemory;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class IMCustomerService implements ICustomerService {
    private List<Customer> customers;


    public IMCustomerService() {
        customers = new ArrayList<>();

        //Customer(long id, String name, String phone, String address,
        // Date createAt, double consumed, CustomerType customerType)

        //dd-MM-yyyy hh:mm
        customers.add(new Customer(1L, "Quang Dang", "0399", "28 NTP",
                DateUtils.parseDate("20-12-2023 08:00"), 0, CustomerType.NORMAL));
        customers.add(new Customer(2L, "Sinh Nhat", "0399", "28 NTP",
                DateUtils.parseDate("20-12-2023 08:00"), 0, CustomerType.NORMAL));
        customers.add(new Customer(3L, "Duong Luc", "0399", "28 NTP",
                DateUtils.parseDate("20-12-2023 08:00"), 0, CustomerType.NORMAL));
        customers.add(new Customer(4L, "Quang Dang", "0399", "28 NTP",
                DateUtils.parseDate("20-12-2023 08:00"), 0, CustomerType.NORMAL));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public Customer findCustomerById(long idCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomer) {
                return customers.get(i);
            }
        }
        return null;
    }
    @Override
    public void updateCustomer(long idCustomer, Customer customer) {
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
    }


}
**/