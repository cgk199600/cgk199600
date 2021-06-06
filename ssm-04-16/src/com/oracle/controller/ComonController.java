package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.bean.PageVo;
import com.oracle.bean.SearchBooks;
import com.oracle.service.BookService;
@RequestMapping("")
@Controller
public class ComonController {
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/member/indexview")
	public String name(@RequestParam(value = "pageIndex",defaultValue = "1",required = false)Integer pageIndex,@RequestParam(value = "pageCount",defaultValue = "1",required = false)Integer pageCount
			,Model model) {
		SearchBooks serBooks=new SearchBooks();
		PageVo list = bookservice.getList(pageIndex, pageCount, serBooks);
		System.out.println(list);
		model.addAttribute("pageInfo",list);
		return "";
		
	}
}
