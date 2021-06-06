package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysUser;
import com.xja.ssm.service.SysUserService;

@Controller
@RequestMapping("sysuser")
public class SysUserController {
@Autowired
private SysUserService sysUserService;
@ResponseBody
@RequestMapping("add")//添加方法
public JsonBean add(SysUser user) {
	return sysUserService.insertuser(user);
	
}
@ResponseBody
@RequestMapping("getTable")//查询方法
public JsonBean getTable() {
	return sysUserService.selectTableList();
	
}
}
