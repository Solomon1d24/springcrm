package com.solomon.springcrm.Controller;

import com.solomon.springcrm.Exception.CustomerNotFoundException;
import com.solomon.springcrm.Model.Customer;
import com.solomon.springcrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customerList = this.customerService.getCustomers();
        return customerList;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = this.customerService.getCustomer(customerId);
        return customer;

    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        this.customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        this.customerService.saveCustomer(customer);
        return customer;

    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = this.customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " is not found in database");
        }

        this.customerService.deleteCustomer(customer);

        return "Customer with Id " + customerId + " is deleted";

    }


}
