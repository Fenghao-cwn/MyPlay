package com.myplay.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myplay.mapper.UserMapper;
import com.myplay.model.Collection;
import com.myplay.model.MyCollection;
import com.myplay.model.User;
import com.myplay.model.Video;
import com.myplay.service.IPersonalCenterService;
import com.myplay.service.IVideoService;

@CrossOrigin
@RestController
@RequestMapping("/Personal")
public class PersonalCenterController {
	
	@Autowired
	private IPersonalCenterService iPersonalCenterService  ;
	@Autowired
	private IVideoService iVideoService;
	/**
	 * 根据id获得个人信息
	 * @param session
	 * @return
	 */
	@GetMapping("/getUser")
	public User getUser(HttpSession session){
		User user=(User) session.getAttribute("user");
		return iPersonalCenterService.selectByPrimaryKey(user.getId());
	}
	/**
	 * 更改个人信息
	 * @param files
	 * @param user
	 */
	@RequestMapping("/updateUser")
	public void updateUser(@RequestParam("file") MultipartFile file,User user,HttpSession session){
		User u=(User) session.getAttribute("user");
		user.setId(u.getId());
		if(file!=null){
			File path = new File("D:/upload");
			//判断文件夹是否存在，不存在则新建一个文件夹
			if(!path.exists()){
				path.mkdirs();
			}
			String name = file.getOriginalFilename();
			String type=name.substring(name.lastIndexOf("."));
			String realname=UUID.randomUUID().toString()+type;
			user.setPhotourl("http://localhost/"+realname);
			File newFile=new File(path,realname);
			try {
				file.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iPersonalCenterService.updateByPrimaryKey(user);
		}
		
	}
	/**
	 * 得到该用户的所有收藏
	 * @param session
	 * @return
	 */
	@GetMapping("/selectMyCollection")
	public List<MyCollection> selectMyCollection(HttpSession session){
		List<MyCollection> myCollections=new ArrayList<MyCollection>();
		User u=(User) session.getAttribute("user");
		//先从收藏表中查到该用户的所有收藏记录
		List<Collection> collections=iVideoService.selectUserCollection(u.getId());
		for (Collection collection : collections) {
			//通过遍历收藏表，根据收藏表的视频id查找所以的视频
			Video video =iVideoService.selectByPrimaryKey(collection.getVid());
			//根据用户id、视频id、作者id查找返回一个自己封装的数组
			List<MyCollection> mcollections= iVideoService.selectMyCollection(video.getId(), video.getUserid());
			for (MyCollection myCollection2 : mcollections) {
				System.out.println(myCollection2.getVid()+myCollection2.getName());
				myCollections.add(myCollection2);
			}
		}
		return myCollections;
	}
	
	
	//删除收藏
	@DeleteMapping("/deleterCollection")
	public void deleterCollection(Integer cid){
		iVideoService.deleteCollectionById(cid);
	}
	/**
	 * 点击作者头像进入作者的个人页面
	 * @param aid   作者id
	 * @return
	 */
	@GetMapping("/selectAuthorById")
	public User selectAuthorById(Integer aid){
		return iPersonalCenterService.selectByPrimaryKey(aid);
	}
	/**
	 * 得到作者的所有视频
	 * @param aid
	 * @return
	 */
	@GetMapping("/selectAuthorVideo")
	public List<Video> selectAuthorVideo(Integer aid){
		return iVideoService.selectVideosByUid(aid);
	}
	
	/**
	 * 得到作者的所有收藏
	 * @param session
	 * @return
	 */
	@GetMapping("/selectAuthorCollection")
	public List<MyCollection> selectAuthorCollection(Integer aid){
		List<MyCollection> myCollections=new ArrayList<MyCollection>();
		//先从收藏表中查到该用户的所有收藏记录
		List<Collection> collections=iVideoService.selectUserCollection(aid);
		for (Collection collection : collections) {
			//通过遍历收藏表，根据收藏表的视频id查找所以的视频
			Video video =iVideoService.selectByPrimaryKey(collection.getVid());
			//根据用户id、视频id、作者id查找返回一个自己封装的数组
			List<MyCollection> mcollections= iVideoService.selectMyCollection(video.getId(), video.getUserid());
			for (MyCollection myCollection2 : mcollections) {
				System.out.println(myCollection2.getVid()+myCollection2.getName());
				myCollections.add(myCollection2);
			}
		}
		return myCollections;
	}
	 
}
