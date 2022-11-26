package com.solomon.springcrm.DaoImpl;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDaoImpl")
@Scope("singleton")
public class CustomerDaoImpl implements CustomerDAO {

  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;

  // get the customers
  @Override
  public List<Customer> getCustomers() {
    List<Customer> customerList;

    Session session = sessionFactory.getCurrentSession();

    Query<Customer> customerQuery =
        session.createQuery("from Customer c ORDER BY c.lastName", Customer.class);

    customerList = customerQuery.getResultList();

    return customerList;
  }

  // get customer with the index

  @Override
  public Customer getCustomer(long index) {
    Session session = sessionFactory.getCurrentSession();

    Query<Customer> query = session.createQuery("FROM Customer c WHERE c.id =:index");

    query.setParameter("index", index);

    Customer customer = query.getSingleResult();

    return customer;
  }
  // get customer with first name and last name

  @Override
  public List<Customer> getCustomer(String firstName, String lastName) {

    List<Customer> customerList;

    Session session = sessionFactory.getCurrentSession();

    Query query =
        session.createQuery("FROM Customer c WHERE c.firstName =: first AND c.lastName =: last");

    customerList = query.getResultList();

    return customerList;
  }

  // delete customers with id
  @Override
  public void deleteCustomerWithId(int id) {
    Session session = sessionFactory.getCurrentSession();

    Query query = session.createQuery("DELETE FROM Customer c WHERE c.id =: index");

    query.setParameter("index", id);

    query.executeUpdate();

    System.out.println(">> Done!");
  }

  // delete customer with name of the customer
  @Override
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

  @Override
  public void deleteCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();

    long index = customer.getId();

    session.delete(customer);

    System.out.println(">> Deleted customer with id of " + index);
  }

  // save a customer

  @Override
  public void saveCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();

    session.saveOrUpdate(customer);

    System.out.println(">> Saved customer " + customer.toString());
  }
  // save a list of customers

  @Override
  public void saveCustomer(List<Customer> customerList) {
    Session session = sessionFactory.getCurrentSession();

    for (Customer customer : customerList) {
      session.saveOrUpdate(customer);
      System.out.println(">> Saved customer " + customer.toString());
    }
  }

  // update a customer
  @Override
  public void updateCustomer(Customer customer) {

    Session session = sessionFactory.getCurrentSession();

    session.saveOrUpdate(customer);

    System.out.println(">> Save or Update with customer " + customer.toString());
  }

  // update a list of Customers
  @Override
  public void updateCustomers(List<Customer> customerList) {
    for (Customer customer : customerList) {
      this.updateCustomer(customer);
    }
  }
}
