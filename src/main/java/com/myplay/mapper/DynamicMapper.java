package com.myplay.mapper;

import java.util.List;

import com.myplay.pojo.Dynamic;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer id);

    List<Dynamic> selectAll();

    int updateByPrimaryKey(Dynamic record);
}