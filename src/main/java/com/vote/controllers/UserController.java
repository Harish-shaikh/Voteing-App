package com.vote.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vote.entity.Candidates;
import com.vote.entity.Message;
import com.vote.entity.User;
import com.vote.repositry.CandidateRepos;
import com.vote.repositry.UserRepos;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserRepos userRepos;
	@Autowired
	private CandidateRepos candidatesRepos;

	// Add common data to the model for each request
	@ModelAttribute
	public void addCommanData(Model model, Principal principal) {
		String username = principal.getName();
		User user = userRepos.getUserByEmail(username);
		model.addAttribute("userName", user);
	}

	@GetMapping("/api1/user/dashboard")
	public String userDashboard(Model m) {
		m.addAttribute("title", "DASHBOARD");
		return "user/userboard";
	}

	@PostMapping("/api1/user/vote")
	public String addVote(@ModelAttribute("datas") Candidates candidates, Model m, HttpSession session, Principal p) {
		try {
			String name = p.getName();
			User user = this.userRepos.getUserByEmail(name);

			// Check if the user has already voted
			boolean alreadyVoted = candidatesRepos.existsByUser(user);
			if (alreadyVoted) {
				// If the user has already voted, set the alreadyVoted attribute to true
				session.setAttribute("message", new Message("You have already vote.", "alert-warning"));
				return "user/userboard"; // Redirect to the userboard page or any appropriate page
			}

			// If the user has not already voted, proceed with saving the vote
			candidates.setUser(user);
			Candidates savedCandidate = this.candidatesRepos.save(candidates);

			// Set success message in session
			session.setAttribute("message", new Message("Your vote is done", "alert-success"));
		} catch (Exception e) {
			// Print stack trace for debugging
			e.printStackTrace();
			// Add user object with errors to the model
			m.addAttribute("candidateDatas", candidates);
			// Set error message in session
			session.setAttribute("message", new Message("Something went wrong: " + e.getMessage(), "alert-danger"));
		}
		return "user/userboard";
	}

}
