package com.myplay.service;

import java.util.List;

import com.myplay.model.Category;
import com.myplay.model.Video;

public interface IVideoService {
	int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAllVideo();

    int updateByPrimaryKey(Video record);
    
    List<Category> selectAllCategory();//找类型
}
