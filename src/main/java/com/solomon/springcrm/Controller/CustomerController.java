package com.solomon.springcrm.Controller;

import com.solomon.springcrm.Dao.CustomerDAO;
import com.solomon.springcrm.Model.Customer;
import com.solomon.springcrm.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("customerController")
@RequestMapping("/customer")
@Scope("singleton")
public class CustomerController {

  // inject the customer service
  @Autowired
  @Qualifier("customerServiceImpl")
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomer(Model model) {

    // get the customers via service
    List<Customer> customerList = customerService.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customerList);

    return "list-customers";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {

    // add a model attribute of customer

    Customer customer = new Customer();

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @PostMapping("saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    // save the customer
    this.customerService.saveCustomer(customer);
    return "redirect:/customer/list";
  }
}
