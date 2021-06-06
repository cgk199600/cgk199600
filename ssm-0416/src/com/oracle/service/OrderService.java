package com.oracle.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.BookMapper;
import com.oracle.mapper.CarbooksMapper;
import com.oracle.mapper.OrderinfoMapper;
import com.oracle.mapper.OrdersMapper;
import com.oracle.pojo.Book;
import com.oracle.pojo.Carbooks;
import com.oracle.pojo.Orderinfo;
import com.oracle.pojo.Orders;

@Service
public class OrderService {
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private OrderinfoMapper  orderinfoMapper;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private CarbooksMapper carbooksMapper;
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public Orders addOrder(Integer userId)throws Exception {
		Orders order=null;
		try {
			order=new Orders();
			order.setCustId(userId);
			List<Carbooks> list = carbooksMapper.getCarByStatusandUserId(userId);
			double sum=0.0;
			List<Orderinfo> orderinfos=new ArrayList<Orderinfo>();
			Orderinfo orderinfo=null;
			for (Carbooks carbooks : list) {
				orderinfo=new Orderinfo();
				
				sum+=carbooks.getBuyNum()*Double.parseDouble(carbooks.getPrice().toString());
				Integer bookId = carbooks.getBookId();
				Book book = bookMapper.selectByPrimaryKey(bookId);
				if(book.getBookNum()<carbooks.getBuyNum()) {
					throw new Exception(book.getBookName()+"数量不足");
				}
				book.setBookNum(book.getBookNum()-carbooks.getBuyNum());
				bookMapper.updateByPrimaryKeySelective(book);
				carbooksMapper.deleteByPrimaryKey(carbooks.getCarId());
				orderinfo.setBookId(bookId);
				orderinfo.setBuyNum(carbooks.getBuyNum());
				orderinfo.setBuyprice(book.getPrice());
				System.out.println("orderInfo===================================="+orderinfo);
				orderinfos.add(orderinfo);
				
			}
			order.setTotalMoney(new BigDecimal(sum));
			order.setBuytime(new Date());
			System.out.println("order===================================="+order);
			ordersMapper.insert(order);
			for (Orderinfo or : orderinfos) {
				or.setOredersId(order.getOrderId());;
				orderinfoMapper.insert(or);
			}
			return order;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
		
	}
}
