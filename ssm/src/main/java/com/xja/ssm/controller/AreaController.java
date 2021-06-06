package com.xja.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.pca_provinces;
import com.xja.ssm.service.AreaService;
import com.xja.ssm.service.UserService;

@Controller
@RequestMapping("area")
public class AreaController {
@Autowired
private  AreaService areaservice;
/*取得所有的省*/
@ResponseBody
@RequestMapping("getProvince")
public List<pca_provinces> name() {
	return areaservice.selectprovience();
	
}
//进页面
@RequestMapping("toArea")
public String toArea(Model model) {
	model.addAttribute("list",areaservice.selectprovience());
	return "area/index";
	
	
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
}
