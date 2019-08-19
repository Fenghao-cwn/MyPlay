package com.myplay.mapper;

import java.util.List;

import com.myplay.model.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();

    int updateByPrimaryKey(Goods record);
}