package com.practice.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.practice.bookclub.models.Book;
import com.practice.bookclub.models.LoginUser;
import com.practice.bookclub.models.User;
import com.practice.bookclub.services.BookService;
import com.practice.bookclub.services.UserService;

@Controller
public class HomeController {

	private final UserService userServ;
	private final BookService bookServ;

	public HomeController(UserService userServ, BookService bookServ) {
		super();
		this.userServ = userServ;
		this.bookServ = bookServ;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	//need route to register
	
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

	//need route to login
	
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
	
	//--logout
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//-- dashboard
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null) {
			
			model.addAttribute("allBooks", bookServ.allBooks());
			model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
			
			return "dashboard.jsp";
		} else {
			
			return "redirect:/";
		}
		
	}
	
	//-- Create
	@GetMapping("/books")
	public String newBook(@ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		
		model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
		return "newBook.jsp";
	}
	
	@PostMapping("makingBook")
	public String makingBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
			return "newBook.jsp";
		}
		bookServ.create(book);
		return "redirect:/dashboard";
	}
	
	//-- See One
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model, HttpSession session) {
		
		model.addAttribute("book", bookServ.findOne(id));
		model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
		
		return "oneBook.jsp";
	}
	
	//--Delete
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/dashboard";
	}
	
	//--Edit
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Long id,
			@ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
		
		model.addAttribute("book", bookServ.findOne(id));
		model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
		
		return "editBook.jsp";
	}
	
	@PutMapping("/editingBook/{id}")
	public String editingBook(@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book, BindingResult result, Model  model, HttpSession session) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("user", userServ.oneUser((Long)session.getAttribute("user_id")));
			
			return "editBook.jsp";
		}
		bookServ.update(book);
		return "redirect:/dashboard";
	}
	
}
