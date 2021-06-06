package com.oracle.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oracle.bean.PageVo;
import com.oracle.bean.SearchBooks;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration("classpath:applicationContext-root.xml")
public class BookServiceTest {
	@Autowired
	private BookService bookService;
	@Test
	public void name() {
		SearchBooks serBooks=new SearchBooks();
serBooks.setBoosName("三");
		PageVo list = bookService.getList(1, 3, serBooks);
		System.out.println(list.toString());
	}
}
