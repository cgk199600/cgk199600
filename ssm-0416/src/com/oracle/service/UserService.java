package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.UserMapper;
import com.oracle.pojo.User;
import com.oracle.pojo.UserExample;
import com.oracle.pojo.UserExample.Criteria;

@Service
public class UserService {
@Autowired
private UserMapper usermapper;

public User getuser(User user) {
	UserExample example=new UserExample();
	Criteria criteria = example.createCriteria();
	criteria.andNameEqualTo(user.getName());
	 List<User> list = usermapper.selectByExample(example);
	 for (User user2 : list) {
		if (user2.getPassword().equals(user.getPassword())) {
			return user2;
		}
	}
	return null;
	
	
}
@Transactional
public void insertUser(User user) {
	usermapper.insertSelective(user);
	
}
@Transactional
public void updatetUser(User user) {
	usermapper.updateByPrimaryKeySelective(user);
	
}
}
