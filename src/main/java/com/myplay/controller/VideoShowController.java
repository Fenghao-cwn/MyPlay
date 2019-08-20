package com.myplay.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.Follow;
import com.myplay.model.User;
import com.myplay.model.UserComment;
import com.myplay.model.Video;
import com.myplay.model.VideoComment;
import com.myplay.service.IVideoShowService;

@CrossOrigin
@RestController
@RequestMapping("/VideoShow")
public class VideoShowController {

	@Autowired
	private IVideoShowService service;
	
	@GetMapping("/sendcomment")
	public String sendComment(VideoComment comment,HttpSession session){
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
		String strDate = s.format(new Date());
		User user = (User) session.getAttribute("user");
		comment.setUid(user.getId());
		comment.setCreattime(strDate);
		int flag = service.insert(comment);
		if(flag!=0){
			return "评论成功";
		}else{
			return "评论失败";
		}
	}
	
	//获取所有用户对视频的评论
	@GetMapping("/allcomment")
	public List<UserComment> getAllComments(){
		return service.selectAllComment();
	}
	
	@GetMapping("/getNewComment")
	public List<UserComment> getNewComment(){
		return service.selectNewComment();
	}
	
	@GetMapping("/getMyComment")
	public List<UserComment> getMyComment(HttpSession session){
		User user =(User) session.getAttribute("user");
		return service.getMyComment(user.getId());
	}
	
	@PostMapping("/loadVideo")
	public Video loadVideo(int id){
		return service.loadVideo(id);
	}
	
	@PostMapping("/loadAuthor")
	public User loadAuthor(Integer id){
		return service.loadAuthor(id);
	}
	
	@PostMapping("/follow")
	public String follow(Integer toUid,HttpSession session){
		System.out.println(session.getId());
		User user = (User) session.getAttribute("user");
		Follow follow = new Follow();
		follow.setFromUid(user.getId());
		follow.setToUid(toUid);
		if(service.follow(follow)!=0){
			return "关注成功";
		}else {
			return "您已关注，请勿重新登录";
		}
		
	}
}
