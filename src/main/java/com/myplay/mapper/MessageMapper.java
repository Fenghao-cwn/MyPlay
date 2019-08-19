package com.myplay.mapper;

import com.myplay.model.Message;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    Message selectByPrimaryKey(Integer id);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);
}