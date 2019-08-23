package com.myplay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.Goods;
import com.myplay.model.GoodsType;
import com.myplay.service.IGoodsService;
import com.myplay.service.IGoodsTypeService;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private IGoodsService goods;
	
	@GetMapping("/select")
	public List<Goods> selectAll(){
		return goods.selectAll();
	}
	
	@GetMapping("/selectById")
	public Goods selectByPrimaryKey(Integer id){
		System.out.println("------------------------");
		System.out.println(goods.selectByPrimaryKey(id));
		return goods.selectByPrimaryKey(id);
	};
	

}
