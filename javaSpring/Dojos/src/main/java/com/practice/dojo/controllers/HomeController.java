package com.practice.dojo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.dojo.models.Dojo;
import com.practice.dojo.models.Ninja;
import com.practice.dojo.services.DojoService;
import com.practice.dojo.services.NinjaService;

@Controller
public class HomeController {
	
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	
	
	public HomeController(NinjaService ninjaServ, DojoService dojoServ) {
		super();
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@GetMapping("/")
	public String index(Dojo dojo, Model model) {
		
		model.addAttribute("allDojos", dojoServ.allDojos());
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		model.addAttribute("allDojos", dojoServ.allDojos());
		
		return "newDojo.jsp";
	}
	
	@PostMapping("/processDojo")
	public String postingDojo(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.allDojos());
			return "newDojo.jsp";
			
		} else {
			
			dojoServ.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		model.addAttribute("allDojos", dojoServ.allDojos());
		
		return "newNinja.jsp";
	}
	
	@PostMapping("/processNinja")
	public String postingNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("allNinjas", ninjaServ.allNinjas());
			return "newNinja.jsp";
			
		} else {
			
			ninjaServ.createNinja(ninja);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/dojos/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("dojo", dojoServ.findDojo(id));
		
		return "dojosNinja.jsp";
	}
	
	

}
