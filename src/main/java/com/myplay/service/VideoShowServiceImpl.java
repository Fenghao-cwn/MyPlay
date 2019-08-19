package com.myplay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.VideoCommentMapper;
import com.myplay.model.VideoComment;

@Service
public class VideoShowServiceImpl implements IVideoShowService{

	@Autowired
	private VideoCommentMapper videoCommentMapper;
	
	@Override
	public int insert(VideoComment comment) {
		// TODO Auto-generated method stub
		return videoCommentMapper.insert(comment);
	}

}
