package com.myplay.mapper;

import com.myplay.model.Follow;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FollowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    Follow selectByPrimaryKey(Integer id);

    List<Follow> selectAll();

    int updateByPrimaryKey(Follow record);

	int loadFollow(@Param("toUid") Integer toUid,@Param("fromUid") Integer fromUid);

	int deleteFollow(Follow follow);
}