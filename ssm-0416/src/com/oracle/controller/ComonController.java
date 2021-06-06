package com.oracle.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.bean.PageVo;
import com.oracle.bean.SearchBooks;
import com.oracle.pojo.Book;
import com.oracle.service.BookService;
@RequestMapping("")
@Controller
public class ComonController {
	@Autowired
	private BookService bookservice;
	
	@RequestMapping("/member/indexview")
	public String name(@RequestParam(value = "page",defaultValue = "1",required = false)Integer pageIndex,@RequestParam(value = "pageCount",defaultValue = "3",required = false)Integer pageCount
			,Model model,SearchBooks searchBooks,HttpServletRequest request) {
		request.getSession().setAttribute("searchbooks", searchBooks);
		System.out.println(request.getSession().getAttribute("searchbooks"));
		PageVo list = bookservice.getList(pageIndex, pageCount, searchBooks);
		//System.out.println(list);
		model.addAttribute("pageInfo",list);
		return "member/index";
		
	}
	@RequestMapping("/member/index")
	public String names(@RequestParam(value = "page",defaultValue = "1",required = false)Integer pageIndex,@RequestParam(value = "pageCount",defaultValue = "3",required = false)Integer pageCount
			,Model model,HttpServletRequest request) {
		
		PageVo list = bookservice.getLists(pageIndex, pageCount);
		//System.out.println(list);
		model.addAttribute("pageInfo",list);
		return "member/index";
		
	}
	
	@RequestMapping("/member/Book")
	public String getBook(Integer bookId,Model model) {
		model.addAttribute("book", bookservice.getBooks(bookId));
		return "/member/Book";
	}
	
}
