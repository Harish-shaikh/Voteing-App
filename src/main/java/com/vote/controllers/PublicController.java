package com.vote.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vote.entity.Message;
import com.vote.entity.User;
import com.vote.repositry.UserRepos;

import jakarta.servlet.http.HttpSession;

@Controller
public class PublicController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepos userRepos;

	@GetMapping("/registration")
	public String home(Model m) {
		// Add title attribute to the model
		m.addAttribute("title", "Registration page");
		return "registration";
	}

	// This is login page method
	@GetMapping("/login")
	public String login(Model m, HttpSession session) {
		// Add title attribute to the model
		m.addAttribute("title", "login page");
		return "login";
	}

	// Add User in database Method
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("data") User user, Model m, HttpSession session) {
		try {
			// Encrypt user's password
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			// Save user to the database
			User saveUser = this.userRepos.save(user);
			// Add new User object to the model
			m.addAttribute("saveUser", new User());
			// Set success message in session
			m.addAttribute("register", "User SuccessFully register");
//			session.setAttribute("message", new Message("User SuccessFully register", "alert-success"));
		} catch (Exception e) {
			// Print stack trace for debugging
			e.printStackTrace();
			// Add user object with errors to the model
			m.addAttribute("data", user);
			// Set error message in session
			session.setAttribute("message", new Message("someting went wrong !!" + e.getMessage(), "alert-danger"));
		}
		return "registration";
	}

}
