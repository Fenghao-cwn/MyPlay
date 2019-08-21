package com.myplay.mapper;

import com.myplay.model.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    Collection selectByPrimaryKey(Integer id);

    List<Collection> selectAll();

    int updateByPrimaryKey(Collection record);

	int loadCollection(@Param("vid")Integer vid,@Param("userid") Integer userid);

	int deleteCollection(Collection collection);
}