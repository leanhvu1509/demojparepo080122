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

import com.lavu.demojparepo.entity.Province;
import com.lavu.demojparepo.service.BaseService;

@Controller
@RequestMapping("/province")
public class ProvinceController {

	@Autowired
	private BaseService<Province> provinceService;

	@ModelAttribute("province")
	public Province getProvince() {
		return new Province();
	}

	@GetMapping("/list-province")
	public String listProvinces(Model model) {
		List<Province> provinces = provinceService.getAll();
		model.addAttribute("provinces", provinces);
		return "province/list-provinces";
	}

	@GetMapping("/show-form")
	public String showFormAdd(Model model) {
		return "province/province-form";
	}

	@PostMapping("/save-province")
	public String saveProvince(@Valid @ModelAttribute("province") Province newProvince, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "province/province-form";
		}
		if (provinceService.existsByName(newProvince.getName()) == true) {
			model.addAttribute("mes", "Da ton tai ");
			return "province/province-form";
		} else {
			provinceService.save(newProvince);
			return "redirect:/province/list-province";
		}
	}

	@GetMapping("/update-province")
	public String showFormUpdate(@RequestParam("pid") int id, Model model) {
		Province oldProvince = provinceService.getByID(id);
		model.addAttribute("province", oldProvince);
		return "province/province-form";
	}

	@GetMapping("/delete-province")
	public String deleteProvince(@RequestParam("pid") int id) {
		provinceService.deleteById(id);
		return "redirect:/province/list-province";
	}
}
