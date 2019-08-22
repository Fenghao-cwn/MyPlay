package com.baidu.ueditor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.Dynamic;
import com.myplay.model.User;
import com.myplay.service.DynamicServiceImpl;


@RestController
@RequestMapping("/dy")
public class dynamicController {

	@Autowired
	DynamicServiceImpl dynamicServiceImpl;
	@PostMapping("/dynamic")
	public void content(String content,HttpSession session) {	
//		User u = (User)session.getAttribute("uu");
	    Dynamic dynamic =	new Dynamic();
	    dynamic.setContent(content);
	    dynamic.setUid(1);
	    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = s.format(new Date());
		dynamic.setCreatetime(strDate);
	    System.out.println(dynamic.getContent());
	    dynamicServiceImpl.insert(dynamic);
		
	}
}
