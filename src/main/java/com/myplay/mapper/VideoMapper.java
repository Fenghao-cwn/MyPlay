package com.myplay.mapper;

import java.util.List;

import com.myplay.model.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}