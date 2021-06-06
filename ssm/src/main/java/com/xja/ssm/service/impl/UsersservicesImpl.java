package com.xja.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.UsersMapper;
import com.xja.ssm.dao.usersMappers;
import com.xja.ssm.entity.User;
import com.xja.ssm.service.UsersService;
import com.xja.ssm.service.usersservices;
@Service
public class UsersservicesImpl implements usersservices {
	@Autowired
	private usersMappers usersmapper;

	//删除
	@Override
	public JsonBean deleteuser(Integer id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",usersmapper.deleteuser(id));
	}
	//展示单个可用于更改的回显
	@Override
	public JsonBean selectuser(Integer id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",usersmapper.selectuser(id));
	}
	//更改数据
	@Override
	public JsonBean updateuser(User users) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",usersmapper.updateuser(users));
	}
	//添加数据
	@Override
	public JsonBean adduser(User users) {
		// TODO Auto-generated method stub
		JsonBean jsonbean=new JsonBean(0,"ok",usersmapper.insertuser(users));
		return jsonbean;
	}
	//展示所有数据
	@Override
	public JsonBean selectUsers() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",usersmapper.selectUsers());
	}

}
