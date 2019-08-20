package com.myplay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myplay.mapper.DynamicMapper;
import com.myplay.model.Dynamic;

@Service
public class DynamicServiceImpl implements IDynamicService{
	@Autowired
	DynamicMapper dynamicMapper;
	
	@Override
	public void insert(Dynamic dynamic) {
		// TODO Auto-generated method stub
		dynamicMapper.insert(dynamic);
	}

	
}
