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
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("showFormForUpdate")
  public String UpdateCustomer(@RequestParam("customerId") long customerId, Model model) {
    // update the customer
    long index = customerId;

    Customer customer = this.customerService.getCustomer(index);

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @GetMapping("showFormForDelete")
  public String deleteCustomer(@RequestParam("customerId") long customerId, Model model) {
    // delete the customer
    long index = customerId;

    Customer customer = this.customerService.getCustomer(index);

    this.customerService.deleteCustomer(customer);

    return "redirect:/customer/list";
  }
}
