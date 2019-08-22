package com.myplay.service;

import java.util.List;

import com.myplay.model.Collection;
import com.myplay.model.User;

public interface IPersonalCenterService {

	    User selectByPrimaryKey(Integer id);

	    List<User> selectAll();
	    	
	    
	    int updateByPrimaryKey(User record);
}
