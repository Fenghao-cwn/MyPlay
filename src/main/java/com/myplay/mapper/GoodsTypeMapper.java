package com.myplay.mapper;

import com.myplay.model.GoodsType;
import java.util.List;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsType record);

    GoodsType selectByPrimaryKey(Integer id);

    List<GoodsType> selectAll();

    int updateByPrimaryKey(GoodsType record);
}