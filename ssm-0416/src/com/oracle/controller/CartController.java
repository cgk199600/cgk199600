package com.oracle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.pojo.Book;
import com.oracle.pojo.Carbooks;
import com.oracle.pojo.User;
import com.oracle.service.BookService;
import com.oracle.service.CartService;
import com.oracle.service.UserService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	@RequestMapping("/member/cart/add")
	@ResponseBody
	public Map ajax(Integer bookId,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userInfo");
		cartService.saveCart(bookId, user.getId());
		Map<String, String> maps=new HashMap<String, String>();
		maps.put("ok", "加入购物车成功");
	return maps;
}
	@RequestMapping("/member/cart/list")
	public String name(Model model,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("userInfo");
		List<Carbooks> cart = cartService.getCart(user.getId());
		for (Carbooks carbooks : cart) {
			Book book = bookService.getBooks(carbooks.getBookId());
			carbooks.setBook(book);
			carbooks.setUser(user);
		}
		System.out.println(cart);
		model.addAttribute("cart",cart);
		return "member/cart";
		
	}
//	@RequestMapping("/member/cart/modifyCarStatus")
//	public @ResponseBody Map name(boolean carStatus,Model model,HttpServletRequest request) {
//		User user = (User) request.getSession().getAttribute("userInfo");
//		
//		int status=carStatus?1:0;
//		cartService.UpdateStatus(status, user.getId());
//		Map<String, Object> maps=new HashMap<String, Object>();
//		maps.put("code", 200);
//		return maps;
//		
//	}
	@RequestMapping("/member/cart/modifyCarStatusById")
	public @ResponseBody Map modifyCarStatusById(boolean carStatus,Integer carId) {
		int status=carStatus?1:0;
		cartService.UpdateStatusById(status, carId);
		Map<String, Integer> maps=new HashMap<String, Integer>();
		maps.put("code", 200);
		return maps;
		
	}
	@RequestMapping("/member/cart/delcar")
	public @ResponseBody Map delCar(Integer carId) {
		
		cartService.delCart(carId);
		Map<String, Integer> maps=new HashMap<String, Integer>();
		maps.put("code", 200);
		return maps;
	}
}
