package com.myplay.mapper;

import com.myplay.model.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollectionMapper {
	Integer deleteByPrimaryKey(Integer id);

    Integer insert(Collection record);

    Collection selectByPrimaryKey(Integer id);

    List<Collection> selectAll();

    Integer updateByPrimaryKey(Collection record);

    Integer loadCollection(@Param("vid")Integer vid,@Param("userid") Integer userid);

	Integer deleteCollection(Collection collection);
	 //根据用户id获得该用户所以收藏
    List<Collection> selectByUserId(Integer uid);
}