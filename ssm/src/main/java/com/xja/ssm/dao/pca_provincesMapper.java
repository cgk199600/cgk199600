package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.pca_provinces;

public interface pca_provincesMapper {
    

    pca_provinces selectByPrimaryKey(String province_id);
//查询所有省
    List<pca_provinces> selectprovience();
}