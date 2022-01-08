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

import com.lavu.demojparepo.entity.Hobby;
import com.lavu.demojparepo.service.BaseService;

@Controller
@RequestMapping("/hobby")
public class HobbyController {

//	@Autowired
//	private BaseService<Customer> customerService;

	@Autowired
	private BaseService<Hobby> hobbyService;
	
	@ModelAttribute("hobby")
	public Hobby getHobby() {
		return new Hobby();
	}
	
	@GetMapping("/list-hobby")
	public String listHobbies(Model model) {
		List<Hobby> hobbies = hobbyService.getAll();
		model.addAttribute("hobbies", hobbies);
		return "hobby/list-hobbies";
	}
	
	@GetMapping("/show-form")
	public String showFormAdd(Model model) {
		return "hobby/hobby-form";
	}
	
	@PostMapping("/save-hobby")
	public String saveHobby(@Valid @ModelAttribute("hobby")Hobby newHobby,BindingResult bindingResult,Model model ) {
		if(bindingResult.hasErrors()) {
			return "hobby/hobby-form";
		}
		if(hobbyService.existsByName(newHobby.getName())==true) {
			model.addAttribute("mes", "Da ton tai ");
			return "hobby/hobby-form";
		}
		hobbyService.save(newHobby);
		return "redirect:/hobby/list-hobby";
	}
	@GetMapping("/update-hobby")
	public String showFormUpdate(@RequestParam("hid")int id,Model model) {
		Hobby oldHobby = hobbyService.getByID(id);
		model.addAttribute("hobby", oldHobby);
		return "hobby/hobby-form";
	}
	@GetMapping("/delete-hobby")
	public String deleteHobby(@RequestParam("hid")int id) {
		hobbyService.deleteById(id);
		return "redirect:/hobby/list-hobby";
	}
}
