package com.myplay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myplay.model.Goods;
import com.myplay.service.IGoodsService;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private IGoodsService goods;

	@GetMapping("/select")
	public List<Goods> selectAll() {
		return goods.selectAll();
	}

	@GetMapping("/selectById")
	public Goods selectById(Integer id) {
		System.out.println("qqq");
		return goods.selectById(id);
	}

	@GetMapping("/addcart")
	public List addCart(HttpSession session, Integer id) {
		Goods item = goods.selectById(id);
		Map<Integer, Goods> cart = (Map) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, Goods>();
			cart.put(id, item);
			session.setAttribute("cart", cart);
		} else {
			if (cart.containsKey(id)) {
				Goods it = cart.get(id);
				it.setNum(it.getNum() + 1);
			} else {
				cart.put(id, item);
			}
		}
		List list = new ArrayList();
		Set<Integer> set = cart.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			list.add(cart.get(it.next()));
		}
		System.out.println(cart);
		return list;
	}

}
