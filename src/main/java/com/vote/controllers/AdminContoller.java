package com.vote.controllers;

import com.vote.entity.Candidates;
import com.vote.repositry.CandidateRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminContoller {

	@Autowired
	private CandidateRepos candidateRepos;

	@GetMapping("/api2/admin/dashboard")
	public String userDashboard(Model model) {
		model.addAttribute("title", "Admin page");

		// Retrieve all candidates from the database
		List<Candidates> candidates = candidateRepos.findAll();

		// Create a map to store the count of votes for each candidate
		Map<String, Integer> candidateVotesCount = new HashMap<>();

		int Candidate1 = 0;
		int Candidate2 = 0;
		int Candidate3 = 0;
		int Candidate4 = 0;
		for (Candidates candidate : candidates) {
			if ((candidate.getCandidate1()) == 1) {
				Candidate1++;
				;
			}
			if ((candidate.getCandidate2()) == 1) {
				Candidate2++;
			}
			if ((candidate.getCandidate3()) == 1) {
				Candidate3++;
			}
			if ((candidate.getCandidate4()) == 1) {
				Candidate4++;
			}

		}

		candidateVotesCount.put("Candidate1", Candidate1);
		candidateVotesCount.put("Candidate2", Candidate2);
		candidateVotesCount.put("Candidate3", Candidate3);
		candidateVotesCount.put("Candidate4", Candidate4);

		// Add the candidateVotesCount map to the model
		model.addAttribute("candidateVotesCount", candidateVotesCount);

		return "admin/adminboard"; // Assuming adminboard.html is your Thymeleaf template
	}
}
