package com.myplay.service;

import java.util.List;

import com.myplay.model.UserComment;
import com.myplay.model.VideoComment;

public interface IVideoShowService {

	int insert(VideoComment comment);
	List<UserComment> selectAllComment();
	List<UserComment> selectNewComment();
	List<UserComment> getMyComment(int id);
}
