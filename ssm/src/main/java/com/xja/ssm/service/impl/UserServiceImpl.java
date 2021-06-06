package com.xja.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.UserMapper;
import com.xja.ssm.entity.User;
import com.xja.ssm.entity.Users;
import com.xja.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectUserbyid(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectList();
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int deleteUserbyid(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override//在layui中必须把code写为0才能出数据 默认写法code：0才算成功
	public JsonBean selectListjson() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",userMapper.selectList());
	}

	@Override
	public JsonBean insertUserJson(User user) {
		// TODO Auto-generated method stub
		JsonBean jsonBean = new JsonBean(-1,"失败",null);
		int i=userMapper.insert(user);
		if(i>0) {
			jsonBean = new JsonBean(0,"成功",null);
		}
		return jsonBean;
	}

	@Override
	public JsonBean selectById(Integer id) {
		// TODO Auto-generated method stub
		
		return new JsonBean(0,"ok",userMapper.selectByPrimaryKey(id));
	}

	@Override
	public JsonBean updateById(User user) {
		JsonBean jsonBean = new JsonBean(-1,"失败",null);
		int i=userMapper.updateByPrimaryKeySelective(user);
		if(i>0) {
			jsonBean = new JsonBean(0,"成功",null);
		}
		return jsonBean;
	}

}
