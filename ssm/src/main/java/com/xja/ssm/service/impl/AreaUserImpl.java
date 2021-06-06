package com.xja.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.pca_areasMapper;
import com.xja.ssm.dao.pca_citiesMapper;
import com.xja.ssm.dao.pca_provincesMapper;
import com.xja.ssm.entity.pca_provinces;
import com.xja.ssm.service.AreaService;
@Service
public class AreaUserImpl implements AreaService {
	@Autowired
	private pca_provincesMapper pca_provincesmapper;
	@Autowired
	private pca_citiesMapper pca_citiesMapper;
	@Autowired
	private pca_areasMapper pca_areasMapper;

	@Override
	public List<pca_provinces> selectprovience() {
		// TODO Auto-generated method stub
		return pca_provincesmapper.selectprovience();
	}

	@Override
	public JsonBean selectByprovince_id(String province_id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",pca_citiesMapper.selectByprovince_id(province_id));
	}

	@Override
	public JsonBean selectBycity_id(String city_id) {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",pca_areasMapper.selectBycity_id(city_id));
	}

}
