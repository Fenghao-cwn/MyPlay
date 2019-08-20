package com.myplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.FollowMapper;
import com.myplay.mapper.UserMapper;
import com.myplay.mapper.VideoCommentMapper;
import com.myplay.mapper.VideoMapper;
import com.myplay.model.Follow;
import com.myplay.model.User;
import com.myplay.model.UserComment;
import com.myplay.model.Video;
import com.myplay.model.VideoComment;

@Service
public class VideoShowServiceImpl implements IVideoShowService{

	@Autowired
	private VideoCommentMapper videoCommentMapper;
	
	@Autowired
	private VideoMapper videomapper;
	
	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private FollowMapper followmapper;
	
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

	@Override
	public Video loadVideo(int id) {
		// TODO Auto-generated method stub
		return videomapper.selectByPrimaryKey(id);
	}

	@Override
	public User loadAuthor(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.selectByPrimaryKey(id);
	}

	@Override
	public int follow(Follow follow) {
		return followmapper.insert(follow);
	}

}
