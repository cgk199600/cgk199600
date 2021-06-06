package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.mapper.BookMapper;
import com.oracle.mapper.CarbooksMapper;
import com.oracle.pojo.Book;
import com.oracle.pojo.Carbooks;
import com.oracle.pojo.CarbooksExample;
import com.oracle.pojo.CarbooksExample.Criteria;

@Service
public class CartService {
	@Autowired
	private CarbooksMapper carbooksMapper;
	
	public void saveCart(Integer bookId,Integer userId) {
		CarbooksExample example=new CarbooksExample();
		Criteria criteria = example.createCriteria();
		criteria.andBookIdEqualTo(bookId);
		List<Carbooks> list = carbooksMapper.selectByExample(example);
		Carbooks carbooks=list.isEmpty()?new Carbooks():list.get(0);
		if(carbooks.getBookId()!=null) {
			carbooks.setBuyNum(carbooks.getBuyNum()+1);
			//System.out.println(carbooks.toString());
			carbooksMapper.updateByExample(carbooks, example);
		}else {
			Carbooks carbooks2=new Carbooks();
			carbooks2.setBookId(bookId);
			carbooks2.setBuyNum(1);
			carbooks2.setCustId(userId);
			carbooks2.setCarStatus(0);
		carbooksMapper.insert(carbooks2);
		}
	}
	
	public List<Carbooks> getCart(Integer userId) {
		CarbooksExample example=new CarbooksExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustIdEqualTo(userId);
		return carbooksMapper.selectByExample(example);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void UpdateStatus(Integer status,Integer UserId) {
		CarbooksExample example=new CarbooksExample();
		Criteria criteria = example.createCriteria();
		Carbooks carbooks=new Carbooks();
		carbooks.setCustId(UserId);
		carbooks.setCarStatus(status);
		criteria.andCustIdEqualTo(UserId);
		carbooksMapper.updateByExampleSelective(carbooks, example);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void UpdateStatusById(Integer status,Integer carId) {
		CarbooksExample example=new CarbooksExample();
		Criteria criteria = example.createCriteria();
		Carbooks carbooks=new Carbooks();
		
		carbooks.setCarStatus(status);
		criteria.andCarIdEqualTo(carId);
		carbooksMapper.updateByExampleSelective(carbooks, example);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delCart(Integer carId) {
		CarbooksExample example=new CarbooksExample();
		Criteria criteria = example.createCriteria();
		criteria.andCarIdEqualTo(carId);
		 carbooksMapper.deleteByExample(example);
		
	}
	public List<Carbooks> getCarBooksByUserIdandStatus(Integer userId) {
		
		List<Carbooks> list = carbooksMapper.getCarByStatusandUserId(userId);
		
		return list;
		
	}
}
