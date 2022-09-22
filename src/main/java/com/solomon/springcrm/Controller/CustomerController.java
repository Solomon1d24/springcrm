package com.solomon.springcrm.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("customerController")
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomer(Model model){
        return "list-customers";
    }

}
