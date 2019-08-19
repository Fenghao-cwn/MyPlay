package com.myplay.mapper;

import com.myplay.model.Dynamic;
import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer id);

    List<Dynamic> selectAll();

    int updateByPrimaryKey(Dynamic record);
}