package com.solomon.springcrm.ServiceImpl;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import com.solomon.springcrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  @Qualifier("customerDaoImpl")
  private CustomerDAO customerDAO;

  @Override
  @Transactional(transactionManager = "transactionManager")
  public List<Customer> getCustomers() {
    List<Customer> customerList = this.customerDAO.getCustomers();

    return customerList;
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public Customer getCustomer(long index) {
    Customer customer = this.customerDAO.getCustomer(index);
    return customer;
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public List<Customer> getCustomer(String firstName, String lastName) {
    List<Customer> customerList = this.customerDAO.getCustomer(firstName, lastName);
    return customerList;
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void deleteCustomerWithId(int id) {
    this.customerDAO.deleteCustomerWithId(id);
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void deleteCustomerWithName(String firstName, String lastName) {
    this.customerDAO.deleteCustomerWithName(firstName, lastName);
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void deleteCustomer(Customer customer) {
      this.customerDAO.deleteCustomer(customer);
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void saveCustomer(Customer customer) {
    this.customerDAO.saveCustomer(customer);
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void saveCustomer(List<Customer> customerList) {
    this.customerDAO.saveCustomer(customerList);
  }

  @Override
  @Transactional(transactionManager = "transactionManager")
  public void updateCustomer(Customer customer) {
    this.customerDAO.updateCustomer(customer);
  }
}
