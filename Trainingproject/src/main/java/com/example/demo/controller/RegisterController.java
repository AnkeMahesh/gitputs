
 package com.example.demo.controller;


 import java.util.Optional;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Repository.Userrepository;
import com.example.demo.model.User;

 @Controller
 public class RegisterController {
 	
 	@Autowired
 	private Userrepository repo;

 	@GetMapping("/Register")
 	public String registerPage(Model model) {
 		return "register";
 	}

 	@PostMapping("/save")
 	public String saveUser(Model model, @ModelAttribute("user") User user) {

 		Optional<User> optional = repo.findById(user.getId());
 		if (optional.isPresent()) {
 			model.addAttribute("Userexist", "User Already Exists");
 			return "register";
 		} else {
 			repo.saveAndFlush(user);
 			model.addAttribute("success", "Register success.....please login!");
 			return "login";

 		}

 	}
 }
