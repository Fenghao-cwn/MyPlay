package com.myplay.service;

import java.util.List;

import com.myplay.model.Goods;

public interface IGoodsService {
	 public List<Goods> selectAll();
	 public Goods selectByPrimaryKey(Integer id);

}
