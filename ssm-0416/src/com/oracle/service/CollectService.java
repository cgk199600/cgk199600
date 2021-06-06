package com.oracle.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.mapper.BookCollectMapper;
import com.oracle.pojo.BookCollect;
import com.oracle.pojo.BookCollectExample;
import com.oracle.pojo.BookCollectExample.Criteria;
import com.oracle.pojo.BookExample;

@Service
public class CollectService {
	@Autowired
	private BookCollectMapper bookCollectMapper;
	
	public void addCollect(BookCollect bookCollect) {
		bookCollectMapper.insert(bookCollect);
		
	}
	
	public List<BookCollect> getCollects(Integer userId) {
		List<BookCollect> list = bookCollectMapper.getCollect(userId);
		
		return list;
		
	}
	public List<Map<String,Object>> getBookNameByMaxBookId() {
		List<Map<String,Object>> list = bookCollectMapper.getBookNameByMaxBookId();
		return list;
	}
	public void removecollect(Integer bookId,Integer userId) {
		BookCollectExample bookExample=new BookCollectExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andBookIdEqualTo(bookId);
		criteria.andUserIdEqualTo(userId);
		bookCollectMapper.deleteByExample(bookExample);
	}
	public List<BookCollect> getcollectByid(Integer bookId,Integer userId) {
		BookCollectExample bookExample=new BookCollectExample();
		Criteria criteria = bookExample.createCriteria();
		criteria.andBookIdEqualTo(bookId);
		criteria.andUserIdEqualTo(userId);
		List<BookCollect> list = bookCollectMapper.selectByExample(bookExample);
		return list;
	}
}
