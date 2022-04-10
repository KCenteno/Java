package com.practice.hello_human;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	@RequestMapping("/")
	
	public String index(@RequestParam(value="q", required=false) String searchQuery) {
		
		if(searchQuery == null) {
			return "Hello Human"; 
		}
		
		return "Hello" + searchQuery;
	}
	

}
