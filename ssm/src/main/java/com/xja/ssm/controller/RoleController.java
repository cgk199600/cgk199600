package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysRole;
import com.xja.ssm.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@ResponseBody//查询所有数据
	@RequestMapping("getTableList")
public JsonBean getTableList() {
	return roleService.selectList();
	
}
	@ResponseBody//添加role表和关联表
	@RequestMapping("add")
public JsonBean add(SysRole role) {
	return roleService.insertrole(role);
	
}
	@ResponseBody//更改role表和关联表
	@RequestMapping("update")
public JsonBean update(SysRole role) {
	return roleService.updaterole(role);
	
}
	@ResponseBody//根据ID查询
	@RequestMapping("getdataByid")
	public JsonBean getdataByid(Integer id) {
		return roleService.getdatabyid(id);
		
	}
}
