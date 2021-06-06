package com.xja.ssm.service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysRole;

public interface RoleService {
	//查询所有表格数据
	JsonBean selectList();
	//1，先添加角色信息加色添加成功后返回主键的ID
	//2,根据角色主键ID和传入的IDS进行r_m添加
	JsonBean insertrole(SysRole role);
	//修改
	JsonBean updaterole(SysRole role);
	//添加时验证权限
	JsonBean selectByName(String rolename);
	//更改页面回显
	JsonBean getdatabyid(Integer id);

}
