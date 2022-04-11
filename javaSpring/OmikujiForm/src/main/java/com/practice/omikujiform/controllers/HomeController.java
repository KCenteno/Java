package com.practice.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

		@RequestMapping("/")
		
		public String home() {
			return "omikujiform.jsp";
		}
		
		@PostMapping("/processing")
		
		public String process(
				@RequestParam("num") int num,
				@RequestParam("city") String city,
				@RequestParam("person") String person,
				@RequestParam("hobby") String hobby,
				@RequestParam("living") String living,
				@RequestParam("nice") String nice,
				HttpSession session
				) {
			
			session.setAttribute("num", num);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("living", living);
			session.setAttribute("nice", nice);
			
			return "redirect:/show";
		}
		
		@RequestMapping("/show")
		
		public String show() {
			
			return "show.jsp";
		}
		
		@RequestMapping("/clear")
		
		public String clear(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
			
	}
