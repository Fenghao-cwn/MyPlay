package com.myplay.mapper;

import java.util.List;

import com.myplay.model.Follow;

public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    Follow selectByPrimaryKey(Integer id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);
}