package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.EmailsMapper;
import com.oracle.pojo.Emails;
import com.oracle.pojo.EmailsExample;
import com.oracle.pojo.EmailsExample.Criteria;

@Service
public class EmailsService {
	@Autowired
	private EmailsMapper emailsMapper;
	//添加邮件
	public boolean insertEmails(Emails emails) {
		int i = emailsMapper.insertSelective(emails);
		return i>0;
	}
	//根据令牌和id查询邮件
	public Emails getemails(Integer id,String token) {
		EmailsExample emailsExample=new EmailsExample();
		Criteria criteria = emailsExample.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andTokenEqualTo(token);
		List<Emails> selectByExample = emailsMapper.selectByExample(emailsExample);
		Emails emails=selectByExample.isEmpty()?new Emails():selectByExample.get(0);
		
		return emails;
		
	}
	//删除邮件
	@Transactional
	public void removeemails(Integer id) {
		
		emailsMapper.deleteByPrimaryKey(id);
		
	}
	//修改邮件
	@Transactional
	public void updateemails(Emails emails) {
		emailsMapper.updateByPrimaryKey(emails);
	}

}
