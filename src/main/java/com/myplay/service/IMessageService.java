package com.myplay.service;

import java.util.List;

import com.myplay.model.LetterBox;

public interface IMessageService {

	//收件箱
	List<LetterBox> getInboxs(Integer id);
	//发件箱
	List<LetterBox> getOutboxs(Integer id);
	//获取信息详情
	LetterBox getMessageById(Integer id);
}
