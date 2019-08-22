package com.myplay.mapper;

import com.myplay.model.Goods;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    List<Goods> selectAll();
    List<Goods> searchByShopCategory(Integer typeid);
    int updateByPrimaryKey(Goods record);

	List<Goods> searchShopByWord(String searchword);
}