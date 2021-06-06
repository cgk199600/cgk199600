package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.pca_cities;

public interface pca_citiesMapper {
   //根据省ID查询所有市
	List<pca_cities> selectByprovince_id(String province_id);

   
}