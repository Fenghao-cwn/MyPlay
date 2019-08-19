package com.myplay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.User;
import com.myplay.model.VideoComment;
import com.myplay.service.IVideoShowService;

@CrossOrigin
@RestController
public class VideoShowController {

	@Autowired
	private IVideoShowService service;
	
	@GetMapping("/sendcomment")
	public String sendComment(VideoComment comment,HttpSession session){
		comment.setUid(1);
		int flag = service.insert(comment);
		User user = (User) session.getAttribute("user");
		
		if(flag!=0){
			return "评论成功";
		}else{
			return "评论失败";
		}
	}
}
