package com.herion.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.herion.entity.User;
import com.herion.service.IUserService;

public class UserServiceImpl implements IUserService{
	static Map<String,User> userMap=new HashMap<String, User>();
	static{
		User user1=new User();
		user1.setUserId(1);
		user1.setUserName("admin");
		user1.setPassword("123456");
		userMap.put("admin", user1);
		
		User user2=new User();
		user2.setUserId(2);
		user2.setUserName("zhanghai");
		user2.setPassword("123456");
		userMap.put("zhanghai", user2);
		
		User user3=new User();
		user3.setUserId(3);
		user3.setUserName("zhangsan");
		user3.setPassword("123456");
		userMap.put("zhangsan", user3);
	}
	
	public User loadUser(String userName){
		return UserServiceImpl.userMap.get(userName);
	}
}
