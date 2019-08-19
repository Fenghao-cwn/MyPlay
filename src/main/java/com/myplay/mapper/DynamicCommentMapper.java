package com.myplay.mapper;

import com.myplay.model.DynamicComment;
import java.util.List;

public interface DynamicCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DynamicComment record);

    DynamicComment selectByPrimaryKey(Integer id);

    List<DynamicComment> selectAll();

    int updateByPrimaryKey(DynamicComment record);
}