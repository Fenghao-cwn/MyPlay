package com.myplay.mapper;

import java.util.List;

import com.myplay.model.Mark;

public interface MarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mark record);

    Mark selectByPrimaryKey(Integer id);

    List<Mark> selectAll();

    int updateByPrimaryKey(Mark record);
}