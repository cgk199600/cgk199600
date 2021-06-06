package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.SysMenu;
import com.xja.ssm.service.SysMenuService;


@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private SysMenuService SysMenuservice;
	
	@ResponseBody
	@RequestMapping("gettableList")
public JsonBean gettableList(SysMenu menu) {
		if(menu.getPid()==null) {//判断menu的pid是否为空
			
			menu.setPid(0);//赋值pid为一级
		}
	return SysMenuservice.selectTableList(menu);
	
}
	@ResponseBody//树状图
	@RequestMapping("getztreeList")
public JsonBean getztreeList() {
	return SysMenuservice.selectztreeList();
	
}
	@ResponseBody//根据ID查询
	@RequestMapping("getdataByid")
public JsonBean getdataByid(Integer id) {
	return SysMenuservice.selectmenuByid(id);
	
}
	@ResponseBody
	@RequestMapping("add")//添加
public JsonBean startadd(SysMenu sysmenu) {
	return SysMenuservice.insertList(sysmenu);
	
}
	@ResponseBody
	@RequestMapping("update")//更改
public JsonBean getztreeupdate(SysMenu sysmenu) {
	return SysMenuservice.updateList(sysmenu);
	
}
	@ResponseBody
	@RequestMapping("getDataByRoleid")//根据roleid查询所有的菜单信息和权限回显
public JsonBean getDataByRoleid(Integer roleid) {
	return SysMenuservice.getDataByRoleid(roleid);
	
}
}
