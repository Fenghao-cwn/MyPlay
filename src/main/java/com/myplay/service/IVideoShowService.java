package com.myplay.service;

import java.util.List;

import com.myplay.model.Collection;
import com.myplay.model.Follow;
import com.myplay.model.User;
import com.myplay.model.UserComment;
import com.myplay.model.Video;
import com.myplay.model.VideoComment;

public interface IVideoShowService {

	int insert(VideoComment comment);
	List<UserComment> selectAllComment();
	List<UserComment> selectNewComment();
	List<UserComment> getMyComment(int id);
	Video loadVideo(int id);
	User loadAuthor(Integer id);
	int follow(Follow follow);
	int collection(Collection collection);
	String loadFollowAndCollection(Integer vid, Integer fromUid);
	int deleteFollow(Follow follow);
	int deleteCollection(Collection collection);
}
