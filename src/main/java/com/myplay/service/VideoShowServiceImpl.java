package com.myplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.CollectionMapper;
import com.myplay.mapper.FollowMapper;
import com.myplay.mapper.UserMapper;
import com.myplay.mapper.VideoCommentMapper;
import com.myplay.mapper.VideoMapper;
import com.myplay.model.Collection;
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
	
	@Autowired
	private CollectionMapper collectionMapper;
	
	@Override
	public int insert(VideoComment comment) {
		return videoCommentMapper.insert(comment);
	}

	@Override
	public List<UserComment> selectAllComment() {
		return videoCommentMapper.selectAll();
	}

	@Override
	public List<UserComment> selectNewComment() {
		return videoCommentMapper.selectNewComment();
	}

	@Override
	public List<UserComment> getMyComment(int id) {
		return videoCommentMapper.getMyComment(id);
	}

	@Override
	public Video loadVideo(int id) {
		return videomapper.selectByPrimaryKey(id);
	}

	@Override
	public User loadAuthor(Integer id) {
		return usermapper.selectByPrimaryKey(id);
	}

	@Override
	public int follow(Follow follow) {
		return followmapper.insert(follow);
	}

	@Override
	public int collection(Collection collection) {
		return collectionMapper.insert(collection);
	}

	@Override
	public String loadFollowAndCollection(Integer vid, Integer fromUid) {
		Video video =videomapper.selectByPrimaryKey(vid);
		Integer toUid=video.getUserid();
		if (followmapper.loadFollow(toUid,fromUid)!=0) {
			if (collectionMapper.loadCollection(vid,fromUid)!=0) {
				return "加载关注收藏成功";
			}else {
				return "加载关注成功";
			}
		}else {
			if (collectionMapper.loadCollection(vid,fromUid)!=0) {
				return "加载收藏成功";
			}else {
				return "加载失败";
			}
		}
	}

	@Override
	public int deleteFollow(Follow follow) {
		return followmapper.deleteFollow(follow);
	}

	@Override
	public int deleteCollection(Collection collection) {
		return collectionMapper.deleteCollection(collection);
	}

}
