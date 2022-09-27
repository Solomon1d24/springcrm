package com.solomon.springcrm.Dao;

import com.solomon.springcrm.Model.Customer;

import java.util.List;

public interface CustomerDAO {

  // save customer

  public void saveCustomer(Customer customer);

  public void saveCustomer(List<Customer> customerList);

  // delete customer

  public void deleteCustomerWithId(int id);

  public void deleteCustomerWithName(String firstName, String lastName);

  public void deleteCustomer(Customer customer);

  // update customer

  public void updateCustomer(Customer customer);

  public void updateCustomers(List<Customer> customerList);

  // get customer
  public List<Customer> getCustomers();

  public Customer getCustomer(long index);

  public List<Customer> getCustomer(String firstName, String lastName);
}
