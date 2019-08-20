package com.myplay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.User;
import com.myplay.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService iUserService;

	@PostMapping("/login")
	public User login(HttpSession session,User user){
		
		User uu = iUserService.login(user);
		session.setAttribute("user", uu);
		System.out.println(uu.getId()+"--"+uu.getName());
		return uu;
		
		
	}
}
