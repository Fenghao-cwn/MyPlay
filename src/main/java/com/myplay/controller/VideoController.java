package com.myplay.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myplay.model.Category;
import com.myplay.model.User;
import com.myplay.model.Video;
import com.myplay.service.IVideoService;

@CrossOrigin
@RestController
@RequestMapping("/Video")
public class VideoController {
	@Autowired
	private IVideoService iVideoService;
	/**
	 * 上传视频
	 * @param files
	 * @param video
	 */
	@PostMapping("/uploadVideo")
	public void uploadVideo(@RequestParam("file") MultipartFile[] files,Video video,HttpSession session){
		
			try {
				User user=(User) session.getAttribute("user");				
				video.setUserid(user.getId());
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String strDate = s.format(new Date());
				video.setCreatetime(strDate);
				File path = new File("D:/upload");
				if(!path.exists()){
					path.mkdirs();
				}
				for(MultipartFile file:files){
					
					String name = file.getOriginalFilename();
					String type=name.substring(name.lastIndexOf("."));
					if(type.equals(".png")||type.equals(".gif")||type.equals(".jpeg")||type.equals(".jpg")){
						String realname=UUID.randomUUID().toString()+type;
						video.setPhotourl("http://localhost/"+realname);
						File newFile=new File(path,realname);
						file.transferTo(newFile);
					}else{
						String realname=UUID.randomUUID().toString()+type;
						video.setVideourl("http://localhost/"+realname);
						File newFile=new File(path,realname);
						file.transferTo(newFile);
					}	
				}
				iVideoService.insert(video);
			}catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	/**
	 * 得到所有视频类型
	 * @return
	 */
	@GetMapping("/selectAllCategory")
	public List<Category> selectAllCategory(){
		
		return iVideoService.selectAllCategory();
	}
	
	
}
