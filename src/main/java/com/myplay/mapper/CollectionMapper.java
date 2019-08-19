package com.myplay.mapper;

import com.myplay.model.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    Collection selectByPrimaryKey(Integer id);

    List<Collection> selectAll();

    int updateByPrimaryKey(Collection record);
}