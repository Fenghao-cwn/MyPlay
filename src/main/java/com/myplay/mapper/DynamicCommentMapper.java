package com.myplay.mapper;

import com.myplay.model.DynamicComment;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DynamicCommentMapper {
	//删除动态评论
    int deleteDynamicComment(Integer id);

    int insert(DynamicComment record);
    
    
    DynamicComment selectByPrimaryKey(Integer id);

    List<DynamicComment> selectAll();
    // 根据did查找我的动态评论 
    List<DynamicComment> selectCommentById(Integer did);

    int updateByPrimaryKey(DynamicComment record);
  //根据from_id查找我的动态评论
	DynamicComment selectByFromUid(Integer from_uid);
}