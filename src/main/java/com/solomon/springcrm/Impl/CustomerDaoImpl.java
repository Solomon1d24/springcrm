package com.solomon.springcrm.Impl;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDAO {

  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;

  // get the customers
  @Override
  @Transactional
  public List<Customer> getCustomers() {
    List<Customer> customerList;

    Session session = sessionFactory.getCurrentSession();

    Query<Customer> customerQuery = session.createQuery("from Customer c", Customer.class);

    customerList = customerQuery.getResultList();

    return customerList;
  }

  // delete customers with id
  @Override
  @Transactional
  public void deleteCustomerWithId(int id) {
    Session session = sessionFactory.getCurrentSession();

    Query query = session.createQuery("DELETE FROM Customer c WHERE c.id =: index");

    query.setParameter("index", id);

    query.executeUpdate();

    System.out.println(">> Done!");
  }

  // delete customer with name of the customer
  @Override
  @Transactional
  public void deleteCustomerWithName(String firstName, String lastName) {
    Session session = sessionFactory.getCurrentSession();

    Query query =
        session.createQuery(
            "DELETE FROM Customer c WHERE c.firstName =: first AND c.lastName =:last");

    query.setParameter("first", firstName);

    query.setParameter("last", lastName);

    query.executeUpdate();

    System.out.println(">> Done!");
  }

  // get customer with the index

  @Override
  @Transactional
  public Customer getCustomer(int index) {
    Session session = sessionFactory.getCurrentSession();

    Query<Customer> query = session.createQuery("FROM Customer c WHERE c.id =:index");

    query.setParameter("index", index);

    Customer customer = query.getSingleResult();

    return customer;
  }
  // get customer with first name and last name

  @Override
  @Transactional
  public List<Customer> getCustomer(String firstName, String lastName) {

    List<Customer> customerList;

    Session session = sessionFactory.getCurrentSession();

    Query query =
        session.createQuery("FROM Customer c WHERE c.firstName =: first AND c.lastName =: last");

    customerList = query.getResultList();

    return customerList;
  }
  // save a customer

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();

    session.save(customer);

    System.out.println(">> Saved customer " + customer.toString());
  }
  // save a list of customers

  @Override
  @Transactional
  public void saveCustomer(List<Customer> customerList) {
    Session session = sessionFactory.getCurrentSession();

    for (Customer customer : customerList) {
      session.save(customer);
      System.out.println(">> Saved customer " + customer.toString());
    }
  }

  // update a customer
  @Override
  @Transactional
  public void updateCustomer(Customer customer) {

    long index = customer.getId();

    String firstName = customer.getFirstName();

    String lastName = customer.getLastName();

    String email = customer.getEmail();

    Session session = sessionFactory.getCurrentSession();

    Query query =
        session.createQuery(
            "UPDATE Customer c SET c.firstName =: first , c.lastName =: last , c.email =: mail WHERE c.id =: id");

    query.setParameter("first", firstName);
    query.setParameter("last", lastName);
    query.setParameter("mail", email);
    query.setParameter("id", index);

    query.executeUpdate();

    System.out.println(">> Update with customer " + customer.toString());
  }


  // update a list of Customers
  @Override
  public void updateCustomers(List<Customer> customerList) {
    for(Customer customer : customerList){
      this.updateCustomer(customer);
    }
  }


}
