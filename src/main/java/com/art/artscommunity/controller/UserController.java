package com.art.artscommunity.controller;


import com.art.artscommunity.model.SignupForm;
import com.art.artscommunity.model.User;
import com.art.artscommunity.repo.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
    private UserRepo repo;

	@GetMapping({"/","/home"})
	public String index() {
		return "home";
	}

	@GetMapping("/account")
	public String account() {
		return "account";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

   	@GetMapping("/register")
    public String addStudent(Model model){
    	model.addAttribute("signupForm", new SignupForm());
        return "register";
    }

	@PostMapping("/saveUser")
    public String save(@Valid SignupForm signupForm, BindingResult bindingResult) {

    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String password = signupForm.getPassword();
		    	BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		    	String hashPassword = bCrypt.encode(password);
	
		    	User user = new User();
				user.setPassword(hashPassword);
				user.setUsername(signupForm.getUsername());
				user.setRole("USER");
		    	if (repo.findByUsername(signupForm.getUsername()) == null) {
		    		repo.save(user);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", ".userExist", "Username already exists");
	    			return "register";
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "error.passwordMatch", "Passwords does not match");
    			return "register";
    		}
    	}
    	else {
    		return "register";
    	}
    	return "redirect:/login";    	
    }    
    
}
