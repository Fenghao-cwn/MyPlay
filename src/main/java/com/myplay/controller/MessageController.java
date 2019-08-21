package com.myplay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.LetterBox;
import com.myplay.model.User;
import com.myplay.service.IMessageService;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	public IMessageService iMessageService;
	
	@GetMapping("/inbox")
	public List<LetterBox> inbox(HttpSession session){
		System.out.println("==inbox==");
		User user = (User)session.getAttribute("user");
		return iMessageService.getInboxs(user.getId());
	} 

	@GetMapping("/outbox")
	public List<LetterBox> outbox(HttpSession session){
		System.out.println("==outbox==");
		User user = (User)session.getAttribute("user");
		return iMessageService.getOutboxs(user.getId());
	}
}