package com.xja.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.UsersMapper;
import com.xja.ssm.entity.Users;
import com.xja.ssm.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
@Autowired
private UsersMapper usersmapper;
	@Override
	public JsonBean insertUsers(Users users) {
		// TODO Auto-generated method stub
		JsonBean jsonBean = new JsonBean(-1,"失败",usersmapper.insert(users));
		int i = usersmapper.insert(users);
		if(i>0) {
			jsonBean = new JsonBean(0,"ok",usersmapper.insert(users));
		}
		return jsonBean;
	}

	@Override
	public JsonBean deleteUsers(Integer id) {
		// TODO Auto-generated method stub
		JsonBean jsonBean = new JsonBean(-1,"失败",usersmapper.deleteByPrimaryKey(id));
		int i = usersmapper.deleteByPrimaryKey(id);
		if(i>0) {
			jsonBean = new JsonBean(0,"ok",usersmapper.deleteByPrimaryKey(id));
		}
		return jsonBean;
	}

	@Override
	public JsonBean updatetUsers(Users users) {
		JsonBean jsonBean = new JsonBean(-1,"失败",usersmapper.updateByPrimaryKeySelective(users));
		int i = usersmapper.updateByPrimaryKeySelective(users);
		if(i>0) {
			jsonBean = new JsonBean(0,"ok",usersmapper.updateByPrimaryKeySelective(users));
		}
		return jsonBean;
	}

	@Override
	public JsonBean selectusers() {
		// TODO Auto-generated method stub
		JsonBean list = new JsonBean(0,"ok",usersmapper.selectList());
		return list;
	}

	@Override
	public Users selectByid(Integer id) {
		// TODO Auto-generated method stub
		return usersmapper.selectByPrimaryKey(id);
	}

	@Override
	public JsonBean selectByidjosn(Integer id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",usersmapper.selectByPrimaryKey(id));
	}

}
