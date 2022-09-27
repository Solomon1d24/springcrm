package com.solomon.springcrm.Service;

import com.solomon.springcrm.Model.Customer;
import java.util.List;

public interface CustomerService {

  public List<Customer> getCustomers();

  public Customer getCustomer(long index);

  public List<Customer> getCustomer(String firstName, String lastName);

  public void deleteCustomerWithId(int id);

  public void deleteCustomerWithName(String firstName, String lastName);

  public void deleteCustomer(Customer customer);

  public void saveCustomer(Customer customer);

  public void saveCustomer(List<Customer> customerList);

  public void updateCustomer(Customer customer);
}
