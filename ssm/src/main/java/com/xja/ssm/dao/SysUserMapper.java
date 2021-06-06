package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);
    //查询用户名是否存在
    SysUser selectByUserName(String username);
//查询数据和连接省市区
    List<SysUser> selectList();
    
    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	
}