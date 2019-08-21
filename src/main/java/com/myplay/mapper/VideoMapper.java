package com.myplay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myplay.model.MyCollection;
import com.myplay.model.Video;
@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAllVideo();
    
    List<Video> selectVideosByUid(Integer userid);//根据用户查找所以视频
    //查询用户的所有收藏
    List<MyCollection>selectMyCollection(@Param("vid")Integer vid,@Param("aid")Integer aid);
    
    int updateByPrimaryKey(Video record);
	List<Video> selectVideosByType(Integer categoryid);
}