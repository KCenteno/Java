package com.practice.fullcrud.controllers;

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

import com.practice.fullcrud.models.Candy;
import com.practice.fullcrud.models.LoginUser;
import com.practice.fullcrud.models.Owner;
import com.practice.fullcrud.models.User;
import com.practice.fullcrud.services.CandyService;
import com.practice.fullcrud.services.OwnerService;
import com.practice.fullcrud.services.UserService;

//min="0.01" step="0.01" 
@Controller
public class HomeController {
	
	private final CandyService candyServ;
	private final UserService userServ;
	private final OwnerService ownerServ;
	
	//Route to show all candies
	// Needs: Model model	
	public HomeController(CandyService candyServ, UserService userServ, OwnerService ownerServ) {
		super();
		this.candyServ = candyServ;
		this.userServ = userServ;
		this.ownerServ = ownerServ;
	}
	
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
		
		userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    	User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		
		
		// Send our Candies to the JSP using Model model
		
		model.addAttribute("allCands", candyServ.allCandys());
		
		
		
		//	=================   This is to check if there is a user logged in  ===========================
		Long user_id = (Long) session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		//================================================================================================
			
		
		
		return "dashboard.jsp";
	}
	
//-----------------------------	Routes to Make a Candy
	
	
	
//	render the new Candy form
	@GetMapping("/newCandy")
	public String newCandyForm(@ModelAttribute("candy") Candy candy, HttpSession session, Model model) {
		
		//	=================   This is to check if there is a user logged in  ===========================
		Long user_id = (Long) session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		//================================================================================================
		
		model.addAttribute("allOwners", ownerServ.allOwners());
		
		return "newCandy.jsp";
	}
	
//	Process the post to create candy
	@PostMapping("/processCandy")
	public String postingCandy(@Valid @ModelAttribute("candy") Candy candy, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("allOwners", ownerServ.allOwners());
			return "newCandy.jsp";
			
		} else {
			
			candyServ.createCandy(candy);
			return "redirect:/dashboard";
		}
		
	}
	
//	render an Owner form
	@GetMapping("/newOwner")
	public String newOwnerForm(@ModelAttribute("owner") Owner owner, HttpSession session) {
		
		//	=================   This is to check if there is a user logged in  ===========================
		Long user_id = (Long) session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		//================================================================================================
		
		
		return "newOwner.jsp";
	}
	
	
	
//	Process the post to create candy
	@PostMapping("/processOwner")
	public String postingOwner(@Valid @ModelAttribute("owner") Owner owner, BindingResult result) {
		
		if(result.hasErrors()) {
			return "newOwner.jsp";
			
		} else {
			
			ownerServ.createOwner(owner);
			return "redirect:/dashboard";
		}
		
	}
	
//	route to show one candy
	@GetMapping("/oneCandy/{id}")
	public String oneCandy(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		//	=================   This is to check if there is a user logged in  ===========================
		Long user_id = (Long) session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		//================================================================================================
		
		model.addAttribute("candy", candyServ.findCandy(id));
		
		return "oneCandy.jsp";
	}
	
//	route to delete one candy
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		
		candyServ.candymMan(id);
		
		return "redirect:/dashboard";
	}
	
//--------------------------------------	routes to update candy
	
//	render the update candy
//	DONT forget to add id
	@GetMapping("/updateCandy/{id}")
	public String updateCandyForm(@PathVariable("id") Long id, @ModelAttribute("candy") Candy candy, Model model, HttpSession session) {
		
		//	=================   This is to check if there is a user logged in  ===========================
		Long user_id = (Long) session.getAttribute("user_id");
		
		if(user_id == null) {
			return "redirect:/";
		}
		//================================================================================================
		
		model.addAttribute("candy", candyServ.findCandy(id));
		model.addAttribute("allOwners", ownerServ.allOwners());
		
		return "updateCandy.jsp";
	}
	
//	process to post the update candy
	@RequestMapping(value="/updatingCandy/{id}", method=RequestMethod.PUT)
	public String updateingCandy(@Valid @ModelAttribute("candy") Candy candy, BindingResult result) {
		if(result.hasErrors()) {
			return "updateCandy.jsp";
		} else {
			candyServ.updateCandy(candy);
			return "redirect:/dashboard";
		}
		
	}
	
	

}
