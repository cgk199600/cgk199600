package com.xja.ssm.service;

import java.util.Map;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysUser;

public interface SysUserService {
	/*
	 * 添加个员工
	 */
	JsonBean insertuser(SysUser user);
	/*
	 * 查询员工
	 */
	JsonBean selectTableList();
	/*
	 * 判断密码用户名
	 */
	JsonBean selectByUsername(String username,String password);
	//根据roleid查询菜单
	Map<String, Object> getmenuByroleId(Integer roleId);
}
