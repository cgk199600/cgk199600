package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.User;
import com.xja.ssm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userservice;
	
	
	///进入list界面
	@RequestMapping("list")
public String list(Model model) {
		model.addAttribute("lists",userservice.selectUsers());
	return "list";
	
}
	//进入添加界面
	@RequestMapping("toAdd")
	public String toAdd() {
		return "add";
		
	}
	//执行添加操作
	//不想返回jsp，想要返回一个.do函数
	@RequestMapping("add")
	public String add(User user) {
		userservice.insertUser(user);
		return "redirect:list.do";
		
	}
	//执行删除
	@RequestMapping("delete")
	public String delete(Integer id) {
		userservice.deleteUserbyid(id);
		return "redirect:list.do";
		
	}
	//进入更改界面
	@RequestMapping("toUpdate")
	public String toupdate(Integer id,Model model) {
		
		model.addAttribute("user",userservice.selectUserbyid(id));
		return "update";
		
	}
	//进入更改操作
		@RequestMapping("update")
		public String update(User user) {
			userservice.updateUser(user);
			return "redirect:list.do";
			
		}
		//layui的json数据
		@ResponseBody
		@RequestMapping("getJson")
		public JsonBean getJson() {
			return userservice.selectListjson();
		}
		//进入layui页面
		@RequestMapping("layui")
		public String name() {
			return "layuicru/layuiList";
			
		}
		//进入layui添加页面
		@RequestMapping("layuiadd")
		public String layuiadd() {
		return "layuicru/add";
					
				}
		@ResponseBody
		@RequestMapping("form")
		public JsonBean toForm(User user) {
			System.out.println(user.toString());
			return userservice.insertUserJson(user);
		}
		//layui的json数据
		@ResponseBody
		@RequestMapping("layuigetByid")
		public JsonBean toForm(Integer id) {
			
			return userservice.selectById(id);
		}
				@RequestMapping("layuiUpdate")
				public String getUserById(Integer id) {
					return "layuicru/layuiUpdate";
				}
	//更改事件
				@ResponseBody
				@RequestMapping("layuitoUpdate")
				public JsonBean  toUpdate(User user) {
					return userservice.updateById(user);
				}
}
