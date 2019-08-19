package com.myplay.mapper;

import java.util.List;

import com.myplay.model.VideoComment;

public interface VideoCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoComment record);

    VideoComment selectByPrimaryKey(Integer id);

    List<VideoComment> selectAll();

    int updateByPrimaryKey(VideoComment record);
}