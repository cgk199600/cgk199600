package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.User;

public interface usersMappers {
	
	int insertuser(User user);
	
	int deleteuser(Integer id);
	
	int updateuser(User user);
	
	User selectuser(Integer id);
	
	List<User> selectUsers(); 

}
