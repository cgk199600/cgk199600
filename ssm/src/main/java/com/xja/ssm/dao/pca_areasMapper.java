package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.pca_areas;

public interface pca_areasMapper {
    
//根据市ID查询区
   List<pca_areas>  selectBycity_id(String city_id);

}