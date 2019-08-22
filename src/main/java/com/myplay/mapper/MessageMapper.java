package com.myplay.mapper;

import com.myplay.model.LetterBox;
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
    
    //收件箱
    List<LetterBox> getInboxs(Integer id);
    
    //发件箱
    List<LetterBox> getOutboxs(Integer id);
 
    //获取信息详情
    LetterBox getMessageById(Integer id);
}