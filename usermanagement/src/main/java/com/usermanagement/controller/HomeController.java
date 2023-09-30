package com.usermanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.usermanagement.model.UserDetail;
import com.usermanagement.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDetail user, HttpSession session) {
		Boolean f = userService.checkEmail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "Email Allresy Exist..Plz Try other");
		} else {
			UserDetail userDetails = userService.createUser(user);
			if (userDetails != null) {
				session.setAttribute("msg", "Registeration Successfull");
			} else {
				session.setAttribute("msg", "Somethink wromg on server");
			}
		}

		return "redirect:/register";
	}

}
