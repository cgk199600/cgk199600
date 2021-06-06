package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.mapper.TypesMapper;
import com.oracle.pojo.Types;
import com.oracle.pojo.TypesExample;

@Service
public class TypeService {
	@Autowired
	private TypesMapper typesMapper;
	@Transactional
	public List<Types> getType() {
		TypesExample typesExample=new TypesExample();
		
		List<Types> list = typesMapper.selectByExample(typesExample);
		return list;
		
	}
	
}
