package com.solomon.springcrm.Model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Objects;

@Entity 
@Table(schema = "sample_crm", name = "customer")
@Component
public class Customer {

  // Generate the fields

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  // Generate the getters and setters

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Generate the Constructors

  public Customer() {}

  public Customer(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  // Generate the toString method

  @Override
  public String toString() {
    return "Customer{"
        + "id="
        + id
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
  // Generate the Equals method


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return id == customer.id && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email);
  }
}
