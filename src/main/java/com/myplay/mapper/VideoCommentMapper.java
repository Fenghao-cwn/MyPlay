package com.myplay.mapper;

import com.myplay.model.VideoComment;
import java.util.List;

public interface VideoCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VideoComment record);

    VideoComment selectByPrimaryKey(Integer id);

    List<VideoComment> selectAll();

    int updateByPrimaryKey(VideoComment record);
}