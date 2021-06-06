package com.xja.ssm.service;

import java.util.List;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.pca_provinces;

public interface AreaService {
	//查询所有省
	List<pca_provinces> selectprovience();
	//查询所有的区
	JsonBean selectByprovince_id(String province_id);
	//查询所有的区
	JsonBean selectBycity_id(String city_id);

}
