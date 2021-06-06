package com.oracle.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.avro.Schema.Field.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.pojo.Carbooks;
import com.oracle.pojo.Orders;
import com.oracle.pojo.User;
import com.oracle.service.BookService;
import com.oracle.service.CartService;
import com.oracle.service.OrderService;
import com.oracle.service.UserService;
@RequestMapping("/member/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@RequestMapping("/create")
	
	public String create(HttpSession session,Model model) {
		
		User user = (User) session.getAttribute("userInfo");
		try {
			Orders order = orderService.addOrder(user.getId());
			System.out.println(order.toString());
			model.addAttribute("orderInfo",order);
			return "/member/order/success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg",e.getMessage());
			return "error";
		}
		
		
	}
}
