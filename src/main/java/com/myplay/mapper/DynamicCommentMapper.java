package com.myplay.mapper;

import java.util.List;

import com.myplay.model.DynamicComment;

public interface DynamicCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DynamicComment record);

    DynamicComment selectByPrimaryKey(Integer id);

    List<DynamicComment> selectAll();

    int updateByPrimaryKey(DynamicComment record);
}