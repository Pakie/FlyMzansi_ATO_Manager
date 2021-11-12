package com.pakie.flymzansi_ato_manager.common_objects.person.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //List Customers
    @GetMapping("/customers")
    //public String customers(){
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/customers";
    }

    @GetMapping("customers/add-customer")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/add_customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    @GetMapping("/customers/update-customer/{id}")
    public String updateCustomer(@PathVariable(value = "id") Long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "customer/update_customer";
    }
    @GetMapping("/customers/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") Long id, Model model){
        this.customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
