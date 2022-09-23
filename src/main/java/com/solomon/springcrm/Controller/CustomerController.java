package com.solomon.springcrm.Controller;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("customerController")
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  @Qualifier("customerDaoImpl")
  private CustomerDAO customerDAO;

  @RequestMapping("/list")
  public String listCustomer(Model model) {

    // get the customers via dao
    List<Customer> customerList = customerDAO.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customerList);

    return "list-customers";
  }
}
