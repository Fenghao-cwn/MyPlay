package com.myplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.CategoryMapper;
import com.myplay.mapper.VideoMapper;
import com.myplay.model.Category;
import com.myplay.model.Video;
@Service
public class VideoServiceImpl implements IVideoService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private VideoMapper videoMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Video record) {
		return videoMapper.insert(record);
	}

	@Override
	public Video selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Video record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Video> selectAllVideo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> selectAllCategory() {
		return categoryMapper.selectAll();
	}

}
