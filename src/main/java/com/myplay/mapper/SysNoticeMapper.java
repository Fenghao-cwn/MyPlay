package com.myplay.mapper;

import com.myplay.model.SysNotice;
import java.util.List;

public interface SysNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysNotice record);

    SysNotice selectByPrimaryKey(Integer id);

    List<SysNotice> selectAll();

    int updateByPrimaryKey(SysNotice record);
}