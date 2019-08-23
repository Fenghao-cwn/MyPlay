package com.myplay.mapper;

import com.myplay.model.Dynamic;
import com.myplay.model.dynamicAndUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DynamicMapper {
	//根据userid查找用户的动态
	List<Dynamic> selectDynamicByUserId(Integer uid);
	//删除我的动态
    int deleteDynamicById(Integer id);

    int insert(Dynamic record);

    Dynamic selectByPrimaryKey(Integer id);

    List<Dynamic> selectAll();

    int updateByPrimaryKey(Dynamic record);

	List<dynamicAndUser> selectdynamibycuser(Integer fromid);
}