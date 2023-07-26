
  package com.example.demo.controller;


  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.Userrepository;
import com.example.demo.model.User;

  

  @Controller
  public class LoginController {
  	@Autowired
  	private Userrepository repository;

  	@GetMapping("/login")
  	public String loginPage(Model model) {

  		return "login";
  	}

  	@PostMapping("/validate")
  	public String getEmployeeDetailsByCredentials(Model model, @RequestParam("id") String id,
  			@RequestParam("password") String password) {

  		User user = repository.findByIdAndPassword(id, password);
  		if (user != null) {
  			model.addAttribute("id", user.getId());
  			model.addAttribute("name", user.getName());
  			model.addAttribute("email", user.getEmail());
  			model.addAttribute("password", user.getPassword());
  			return "profile";
  		} else {

  			model.addAttribute("error", "invalid Credentials");
  			return "login";
  		}
  	}

  }
