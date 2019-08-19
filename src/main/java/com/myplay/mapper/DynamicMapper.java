package com.myplay.mapper;

import com.myplay.model.Dynamic;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DynamicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer id);

    List<Dynamic> selectAll();

    int updateByPrimaryKey(Dynamic record);
}