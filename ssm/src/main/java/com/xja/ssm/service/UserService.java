package com.xja.ssm.service;

import java.util.List;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.User;
import com.xja.ssm.entity.Users;

public interface UserService {
	User selectUserbyid(int id);
	 
	List<User> selectUsers();
	
	int insertUser(User user);
	//实现layui提交的一个模拟添加json格式方法
	JsonBean insertUserJson(User user); 
	
	int updateUser(User user);
	
	int deleteUserbyid(int id);
	//用于layui的查询
	JsonBean selectListjson();
	//用于layui根据id查询
	JsonBean selectById(Integer id);
	//更改layui根据id更改
	JsonBean updateById(User user);

}
