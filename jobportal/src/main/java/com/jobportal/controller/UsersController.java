package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import com.jobportal.entity.Users;
import com.jobportal.entity.UsersType;
import com.jobportal.services.UsersService;
import com.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {
	private final UsersTypeService usersTypeService;
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
		this.usersTypeService=usersTypeService;
		this.usersService=usersService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes=usersTypeService.getAll();
		model.addAttribute("getAllTypes",usersTypes);
		model.addAttribute("user", new Users());
		return "register";
	}
	
	@PostMapping("/register/new")
	public String usersRegistration(Users users,Model model) {
		//System.out.println("User:: "+users);
		Optional<Users> optionalUsers= usersService.getUserByEmail(users.getEmail());
		
		if(optionalUsers.isPresent())
		{
			model.addAttribute("error", "Email already registered, try to login or register with another email.");
			List<UsersType> usersTypes=usersTypeService.getAll();
			model.addAttribute("getAllTypes",usersTypes);
			model.addAttribute("user", new Users());
			return "register";
		}
		usersService.addNew(users);
		return "dashboard";
	}
	
}
