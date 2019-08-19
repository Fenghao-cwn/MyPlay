package com.myplay.mapper;

import java.util.List;

import com.myplay.model.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    Message selectByPrimaryKey(Integer id);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);
}