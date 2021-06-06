package com.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oracle.bean.PageVo;
import com.oracle.bean.SearchBooks;
import com.oracle.mapper.BookMapper;
import com.oracle.pojo.Book;
import com.oracle.pojo.BookExample;
import com.oracle.pojo.BookExample.Criteria;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	@Transactional
	public PageVo getList(Integer pageIndex,Integer pageCount,SearchBooks serBooks) {
		Page<Book> page = PageHelper.startPage(pageIndex,pageCount);
		BookExample example=new BookExample();
		Criteria criteria = example.createCriteria();
		if (serBooks.getBoosName()!=null&&!"".equals(serBooks.getBoosName())) {
			criteria.andBookNameLike("%"+serBooks.getBoosName()+"%");
		}
		if (serBooks.getTypeId()!=null&&!"".equals(serBooks.getTypeId())) {
			criteria.andTypeIdEqualTo(serBooks.getTypeId());
		}
		if (serBooks.getMinPrice()!=null&&!"".equals(serBooks.getMinPrice())) {
			criteria.andPriceGreaterThanOrEqualTo(serBooks.getMinPrice());
		}
		if (serBooks.getMaxPrice()!=null&&!"".equals(serBooks.getMaxPrice())) {
			criteria.andPriceLessThanOrEqualTo(serBooks.getMaxPrice());
		}
		bookMapper.selectByExample(example);
		PageVo pagevo=new PageVo();
		pagevo.setList(page.getResult());
		pagevo.setPageCount(pageCount);
		pagevo.setPageIndex(pageIndex);
		//不需要再获取select的结果集直接从page中获取
		
		pagevo.setTotalPage(page.getPages());
		//应为parseint是转换字符串的但获得的是long所以需要先转为字符串(连接空字符)再转int
		pagevo.setallPage(Integer.parseInt(page.getTotal()+""));
		//System.out.println(page.getResult().toString());
		return pagevo;
	}
	@Transactional
	public PageVo getLists(Integer pageIndex,Integer pageCount) {
		Page<Book> page = PageHelper.startPage(pageIndex,pageCount);
		BookExample example=new BookExample();
		bookMapper.selectByExample(example);
		PageVo pagevo=new PageVo();
		pagevo.setList(page.getResult());
		pagevo.setPageCount(pageCount);
		pagevo.setPageIndex(pageIndex);
		pagevo.setTotalPage(page.getPages());
		pagevo.setallPage(Integer.parseInt(page.getTotal()+""));
		//System.out.println(page.getResult().toString());
		return pagevo;
	}
	@Transactional
	public Book getBooks(Integer bookId) {
		return bookMapper.selectByPrimaryKey(bookId);
		
	}
}
