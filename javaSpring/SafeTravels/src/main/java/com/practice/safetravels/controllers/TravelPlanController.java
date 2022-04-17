package com.practice.safetravels.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.safetravels.models.TravelPlan;
import com.practice.safetravels.services.TravelPlanService;

@Controller
public class TravelPlanController {

	private final TravelPlanService travelServ;
	
	
	public TravelPlanController(TravelPlanService travelServ) {
		this.travelServ = travelServ;
	}
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("travelPlan") TravelPlan travelPlan, Model model) {
		
		model.addAttribute("allPlans", travelServ.allTravelPlans());
		
		return "index.jsp";
	}
	
	@PostMapping("/processPlan")
	public String postingPlan(@Valid @ModelAttribute("travelPlan") TravelPlan travelPlan, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("allPlans", travelServ.allTravelPlans());
			return "index.jsp";
			
		} else {
			
			travelServ.createTravelPlan(travelPlan);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/updatePlan/{id}")
	public String updateTravelForm(@PathVariable("id") Long id, @ModelAttribute("travelPlan") TravelPlan travelPlan, Model model) {
		
		
		model.addAttribute("travelPlan", travelServ.findTravelPlan(id));
		
		return "update.jsp";
	}
	
//	process to post the update candy
	@RequestMapping(value="/updatingPlan/{id}", method=RequestMethod.PUT)
	public String updatingPlan(@Valid @ModelAttribute("travelPlan") TravelPlan travelPlan, BindingResult result) {
		if(result.hasErrors()) {
			return "update.jsp";
		} else {
			travelServ.updatePlan(travelPlan);
			return "redirect:/dashboard";
		}
		
	}
	
//	route to delete one candy
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		
		travelServ.traveldelete(id);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/onePlan/{id}")
	public String onePlan(@PathVariable("id")Long id, Model model) {
		
		model.addAttribute("travelPlan", travelServ.findTravelPlan(id));
		
		return "show.jsp";
	}
	
	
	
}
