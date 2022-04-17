package com.practice.fullcrud.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.practice.fullcrud.models.LoginUser;
import com.practice.fullcrud.models.User;
import com.practice.fullcrud.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
         // TO-DO - Reject values or register if no errors:
            
         // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "You can not use this Email, pick a differnet Email!");
    	}
    	
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Your password and confirm password must match!");
        }
        
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        
        return userRepo.save(newUser);
    }
    
    
    public User login(LoginUser newLogin, BindingResult result) {
    	// TO-DO - Reject values:
            
        // Find user in the DB by email
        // Reject if NOT present
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Unique", "We don't know who you are! Email does not eist in the Database!");
    		return null;
    	}
           
    	User user = potentialUser.get();
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "That password doesnt match the password for this Email");
        	return null;
        }
        // Return null if result has errors
        
        if(result.hasErrors()) {
        	return null;
        } else {
        	// Otherwise, return the user object
        	return user;
        }
    }
    
    
}
