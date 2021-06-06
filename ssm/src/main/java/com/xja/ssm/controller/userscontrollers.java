package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.User;
import com.xja.ssm.service.UserService;
import com.xja.ssm.service.usersservices;

@Controller
@RequestMapping("Users")
public class userscontrollers {
	@Autowired
	private usersservices usersservice;
	
	//进入展示页面
	@RequestMapping("list")
	public String ToList(Model model) {
		model.addAttribute("list", usersservice.selectUsers());
		return "list";
	}
	
	//删除数据
	@ResponseBody
	@RequestMapping("delete")
	public JsonBean deleteByid(Integer id) {
		return usersservice.deleteuser(id);
	}
	//执行更改操作
	@ResponseBody
	@RequestMapping("update")
	public JsonBean update(User user) {
		
		return usersservice.updateuser(user);
		
	}
	//进入更改页面
	@RequestMapping("toupdate")
	public String toupdate(Model model,Integer id) {
		model.addAttribute("user", usersservice.selectuser(id));
		return "update";
	}
	//进入添加页面
	@RequestMapping("toadd")
	public String toadd() {
		return "add";
	}
	
	//执行添加操作
	@ResponseBody
	@RequestMapping("add")
	public JsonBean add(User user) {
		return usersservice.adduser(user);
		
	}
	
}
