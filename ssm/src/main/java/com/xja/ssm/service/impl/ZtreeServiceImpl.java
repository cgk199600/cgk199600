package com.xja.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.ZtreeMapper;
@Service
public class ZtreeServiceImpl implements com.xja.ssm.service.ZtreeService {
@Autowired
private ZtreeMapper ZtreeMapper;
	@Override
	public JsonBean selectList() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",ZtreeMapper.selectByPrimaryKey());
	}

}
