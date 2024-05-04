package com.vote.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.entity.Candidates;
import com.vote.entity.User;

@Repository
public interface CandidateRepos extends JpaRepository<Candidates, Integer> {
	 boolean existsByUser(User user);
}
