package com.myplay.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.Collection;
import com.myplay.model.Follow;
import com.myplay.model.User;
import com.myplay.model.UserComment;
import com.myplay.model.Video;
import com.myplay.model.VideoComment;
import com.myplay.service.IVideoShowService;


@RestController
public class VideoShowController {

	@Autowired
	private IVideoShowService service;
	
	@GetMapping("/sendcomment")
	public String sendComment(VideoComment comment,HttpSession session){
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	/**
	 * 关注某人
	 * @param toUid
	 * @param session
	 * @return
	 */
	@GetMapping("/follow")
	public String follow(Integer toUid,HttpSession session){
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
	/**
	 * 收藏
	 * @param collection
	 * @param session
	 * @return
	 */
	@PostMapping("/collection")
	public String collection(Collection collection ,HttpSession session){
		User user = (User) session.getAttribute("user");
		collection.setUid(user.getId());//设置收藏人的id
		if(service.collection(collection)!=0){
			return "收藏成功";
		}else {
			return "收藏失败，请重试！";
		}
	}
	
	@PostMapping("/loadFollowAndCollection")
	public String loadFollowAndCollection(Integer vid,HttpSession session){
		User user = (User) session.getAttribute("user");
		return service.loadFollowAndCollection(vid,user.getId());
	}
	
	@DeleteMapping("/follow")
	public String deleteFollow(Follow follow,HttpSession session){
		User user = (User) session.getAttribute("user");
		follow.setFromUid(user.getId());
		service.deleteFollow(follow);
		return "已取消关注";
	}
	
	@DeleteMapping("/collection")
	public String deleteCollection(Collection collection,HttpSession session){
		User user = (User) session.getAttribute("user");
		collection.setUid(user.getId());
		service.deleteCollection(collection);
		return "已取消收藏";
	}
}
