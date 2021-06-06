package com.xja.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.service.ZtreeService;
import com.xja.ssm.service.impl.ZtreeServiceImpl;

@Controller
@RequestMapping("ztree")
public class ZtreeController {
	
	 @Autowired
	 private ZtreeService ZtreeService;
	 
	
	//进入ztree页面
	@RequestMapping("index")
public String name() {
	return "ztree";
	
}


 @ResponseBody 
  @RequestMapping("getZtree") 
 public JsonBean getZtree()
 { 	 
	 return ZtreeService.selectList();
  
  } }
 
