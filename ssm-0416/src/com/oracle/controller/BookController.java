package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("book")
@Controller
public class BookController {
	@RequestMapping("/member/add")
public String name(Integer bookId) {
	
	return null;
	
}
}
