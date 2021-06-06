package com.xja.ssm.service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysMenu;

public interface SysMenuService {
	//添加方法
	JsonBean insertList(SysMenu sysmenu);
	//更改方法
	JsonBean updateList(SysMenu sysmenu);
	//根据ID查询
	JsonBean selectmenuByid(Integer id);
	//查询目录
	JsonBean selectztreeList();
	//根据pid查询节点
	JsonBean selectTableList(SysMenu sysmenu);
	//查询权限回显
	JsonBean getDataByRoleid(Integer roleid);
	
	
	
	

}
