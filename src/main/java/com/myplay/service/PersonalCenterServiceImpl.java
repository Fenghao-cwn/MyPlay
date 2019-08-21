package com.myplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.CollectionMapper;
import com.myplay.mapper.UserMapper;
import com.myplay.model.Collection;
import com.myplay.model.User;
@Service
public class PersonalCenterServiceImpl implements IPersonalCenterService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CollectionMapper collectionMapper;
	@Override
	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	 
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(User record) {		
		return userMapper.updateByPrimaryKey(record);
	}

}
