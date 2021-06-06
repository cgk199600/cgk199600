package com.xja.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.SysMenuMapper;
import com.xja.ssm.entity.SysMenu;
import com.xja.ssm.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override//添加
	public JsonBean insertList(SysMenu sysmenu) {
		// TODO Auto-generated method stub
		JsonBean jsonbean=new JsonBean(-1,"失败",null);
		int i = sysMenuMapper.insert(sysmenu);
		if(i>0) {
			jsonbean=new JsonBean(0,"成功",null);
		}
		return jsonbean;
	}

	@Override//更改
	public JsonBean updateList(SysMenu sysmenu) {
		JsonBean jsonbean=new JsonBean(-1,"失败",null);
		int i = sysMenuMapper.updateByPrimaryKey(sysmenu);
		if(i>0) {
			jsonbean=new JsonBean(0,"成功",null);
		}
		return jsonbean;
	}

	@Override
	public JsonBean selectmenuByid(Integer id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"成功",sysMenuMapper.selectByPrimaryKey(id));
	}

	@Override//通过传入null值得到空再在前端赋值树状图
	public JsonBean selectztreeList() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"成功",sysMenuMapper.selectmenuListbypid(null));
	}

	@Override//
	public JsonBean selectTableList(SysMenu sysmenu) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"成功",sysMenuMapper.selectmenuListbypid(sysmenu));
	}

	@Override//根据角色ID查询权限回显
	public JsonBean getDataByRoleid(Integer roleid) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"成功",sysMenuMapper.selectTreeObj(roleid));
	}

	
}
