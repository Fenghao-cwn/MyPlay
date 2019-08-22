package com.myplay.mapper;

import com.myplay.model.Video;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    Video selectByPrimaryKey(Integer id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
    //审核通过
    int updateforpass(Integer videoid);
    //审核退回
    int updatefornotpass(Integer videoid);
    
	List<Video> selectVideosByType(Integer categoryid);
	//模糊查询
	List<Video> searchByWord(String searchword);
	//类型查询
	List<Video> searchByCategory(Integer categoryid);
	
}