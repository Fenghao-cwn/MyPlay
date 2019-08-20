package com.myplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.VideoCommentMapper;
import com.myplay.model.UserComment;
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

	@Override
	public List<UserComment> selectAllComment() {
		// TODO Auto-generated method stub
		return videoCommentMapper.selectAll();
	}

	@Override
	public List<UserComment> selectNewComment() {
		// TODO Auto-generated method stub
		return videoCommentMapper.selectNewComment();
	}

	@Override
	public List<UserComment> getMyComment(int id) {
		// TODO Auto-generated method stub
		return videoCommentMapper.getMyComment(id);
	}

}
