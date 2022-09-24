package com.solomon.springcrm.ServiceImpl;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import com.solomon.springcrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  @Qualifier("customerDaoImpl")
  private CustomerDAO customerDAO;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    List<Customer> customerList = this.customerDAO.getCustomers();

    return customerList;
  }

  @Override
  @Transactional
  public Customer getCustomer(int index) {
    Customer customer = this.customerDAO.getCustomer(index);
    return customer;
  }

  @Override
  @Transactional
  public List<Customer> getCustomer(String firstName, String lastName) {
    List<Customer> customerList = this.customerDAO.getCustomer(firstName, lastName);
    return customerList;
  }

  @Override
  @Transactional
  public void deleteCustomerWithId(int id) {
    this.customerDAO.deleteCustomerWithId(id);
  }

  @Override
  @Transactional
  public void deleteCustomerWithName(String firstName, String lastName) {
    this.customerDAO.deleteCustomerWithName(firstName, lastName);
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    this.customerDAO.saveCustomer(customer);
  }

  @Override
  @Transactional
  public void saveCustomer(List<Customer> customerList) {
    this.customerDAO.saveCustomer(customerList);
  }

  @Override
  @Transactional
  public void updateCustomer(Customer customer) {
    this.customerDAO.updateCustomer(customer);
  }
}
