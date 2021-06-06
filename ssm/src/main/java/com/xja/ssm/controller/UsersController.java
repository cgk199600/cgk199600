package com.xja.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.User;
import com.xja.ssm.entity.Users;
import com.xja.ssm.entity.pca_provinces;
import com.xja.ssm.service.AreaService;
import com.xja.ssm.service.UserService;
import com.xja.ssm.service.UsersService;
@Controller
@RequestMapping("users")
public class UsersController {
	@Autowired
	private  AreaService areaservice;
	
	@Autowired
	private UsersService usersservice;
	///进入list界面
		@RequestMapping("list")
	public String list() {
		return "users/list";
		
	}
		@ResponseBody
		@RequestMapping("getListdata")
		public JsonBean getList() {
			return usersservice.selectusers();
			
		}
		//进入添加界面
		@RequestMapping("toAdd")
		public String toAdd() {
			return "users/add";
			
		}
		//执行添加操作
		@ResponseBody
		@RequestMapping("add")
		public JsonBean add(Users users) {
			
			return usersservice.insertUsers(users);
			
		}
		//执行删除
		@ResponseBody
		@RequestMapping("delete")
		public JsonBean delete(Integer id) {
			
			return usersservice.deleteUsers(id);
			
		}
		//进入更改界面
		@RequestMapping("toUpdate")
		public String toupdate(Integer id,Model model) {
			
			Model updatelist = model.addAttribute("user",usersservice.selectByid(id));
			return "users/update";
			
		}
		@ResponseBody
		@RequestMapping("update")
		public JsonBean update(Users users) {
			
			return usersservice.updatetUsers(users);
			
		}
		
		/*取得所有的省*/
		@ResponseBody
		@RequestMapping("getProvince")
		public List<pca_provinces> name() {
			return areaservice.selectprovience();
			
		}
		
		//根据省ID找所有市
		@ResponseBody
		@RequestMapping("getCity")
		public JsonBean getCity(String province_id) {
			return areaservice.selectByprovince_id(province_id);
			
		}
		//根据市ID找所有区
		@ResponseBody
		@RequestMapping("getArea")
		public JsonBean getArea(String city_id) {
			return areaservice.selectBycity_id(city_id);
			
		}
		@ResponseBody
		@RequestMapping("getjson")
		public JsonBean josnId(Integer id) {
			return usersservice.selectByidjosn(id);
			
		}
}
