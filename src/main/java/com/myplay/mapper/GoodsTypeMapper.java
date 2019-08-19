package com.myplay.mapper;

import java.util.List;

import com.myplay.model.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    List<GoodsType> selectAll();

    int updateByPrimaryKey(GoodsType record);
}