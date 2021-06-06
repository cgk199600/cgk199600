package com.oracle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.pojo.BookCollect;
import com.oracle.pojo.User;
import com.oracle.service.CollectService;

@RequestMapping("/member/collect")
@Controller
public class CollectController {
	@Autowired
	private CollectService CollectService;
	@RequestMapping("/addcollect")
	@ResponseBody
	public  Map name(Integer bookId,HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		BookCollect bookCollect=new BookCollect();
		bookCollect.setUserId(user.getId());
		bookCollect.setBookId(bookId);
		CollectService.addCollect(bookCollect);
		Map<String, Integer> maps=new HashMap<String, Integer>();
		maps.put("code", 200);
		return maps;
	}
	@RequestMapping("/getcollect")
	public  String getCollects(HttpSession session,Model model) {
		User user = (User) session.getAttribute("userInfo");
		List<BookCollect> list = CollectService.getCollects(user.getId());
		System.out.println(list);
		model.addAttribute("list", list);
		return "member/collect";
	}
	@RequestMapping("/getcollectByMaxbookid")
	
	public @ResponseBody Map getCollectsBymaxbookId() {
		 List<Map<String,Object>> list = CollectService.getBookNameByMaxBookId();
		 Map<String,Object> maps=new HashMap<String, Object>();
		 maps.put("list", list);
		 System.out.println(maps);
		return maps;
	}
	@RequestMapping("/deltecollect")
	
	public @ResponseBody Map deltecollect(Integer bookId,HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		CollectService.removecollect(bookId,user.getId());
		 Map<String,Integer> maps=new HashMap<String, Integer>();
		 maps.put("code", 200);
		return maps;
	}
	@RequestMapping("/getCollectBybookId")
	public  @ResponseBody Map getCollectBybookId(Integer bookId,HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		
		List<BookCollect> list = CollectService.getcollectByid(bookId,user.getId());
		Map<String,Integer> maps=null;
		if(!list.isEmpty()) {
		maps=new HashMap<String, Integer>();
		 maps.put("code", 200);
		}
		return maps;
	}
}
