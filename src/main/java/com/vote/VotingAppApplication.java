package com.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingAppApplication.class, args);
		System.out.println("Server is runing");
	}

}
