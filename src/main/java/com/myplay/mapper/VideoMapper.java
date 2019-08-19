package com.myplay.mapper;

import com.myplay.model.Video;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}