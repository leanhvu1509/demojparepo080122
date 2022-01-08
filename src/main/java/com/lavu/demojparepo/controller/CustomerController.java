package com.lavu.demojparepo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lavu.demojparepo.entity.Customer;
import com.lavu.demojparepo.entity.Hobby;
import com.lavu.demojparepo.entity.Province;
import com.lavu.demojparepo.service.BaseService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private BaseService<Customer> customerService;

	@Autowired
	private BaseService<Province> provinceService;

	@Autowired
	private BaseService<Hobby> hobbyService;

	@ModelAttribute("provinces")
	public List<Province> provinces() {
		return provinceService.getAll();
	}

	@ModelAttribute("hobbies")
	public List<Hobby> hobbies() {
		return hobbyService.getAll();
	}

	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

	@GetMapping("/list-customer")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);
		return "customer/list-customers";
	}

	@GetMapping("/show-form")
	public String showFormAdd(Model model) {
		return "customer/customer-form";
	}

	@PostMapping("/save-customer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer newCustomer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "customer/customer-form";
		}
		if (customerService.existsByEmail(newCustomer.getEmail()) == true) {
			model.addAttribute("mes", "email da ton tai");
			return "customer/customer-form";
		} else {
			customerService.save(newCustomer);
			return "redirect:/customer/list-customer";
		}
	}

	@GetMapping("/update-customer")
	public String showFormUpdate(@RequestParam("cid") int id, Model model) {
		Customer oldCustomer = customerService.getByID(id);
		model.addAttribute("customer", oldCustomer);
		return "customer/customer-form";
	}

	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam("cid") int id) {
		customerService.deleteById(id);
		return "redirect:/customer/list-customer";
	}

}
