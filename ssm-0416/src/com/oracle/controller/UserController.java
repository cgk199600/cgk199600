package com.oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.pojo.User;
import com.oracle.service.UserService;
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	@RequestMapping("/login")
public String login(User user,HttpServletRequest request) {
	User b = userservice.getuser(user);
	
	if(b.getId()!=null) {
		request.getSession().setAttribute("userInfo", b);
		return "redirect:/member/indexview";
	}
	return "user/login";
	
}
	
	
	@RequestMapping("/index")
	public String index() {
		
		return "user/login";
		
	}
	@RequestMapping("/UserRegireste")
	public String UserRegireste() {
		
		return "user/UserRegireste";
		
	}
	@RequestMapping("/AddUser")
	public String AddUser(User user,Model model) {
		userservice.insertUser(user);
		model.addAttribute("userId",user.getId());
		return "user/emailsRegirester";
		
	}
}
