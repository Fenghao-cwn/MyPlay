package com.baidu.ueditor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.ActionEnter;

@RestController
@RequestMapping("/ueditor")
@CrossOrigin(allowCredentials = "true")
public class UeditorController {
	@RequestMapping(value = "/config")
	public void config(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootPath);
		try {
			String exec = new ActionEnter(request, rootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/contents")
	public void content(String content) {
		System.out.println("是否");
		System.out.println(content);
		
	}
}