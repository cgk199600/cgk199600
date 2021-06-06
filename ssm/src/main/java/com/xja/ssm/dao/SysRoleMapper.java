package com.xja.ssm.dao;

import java.util.List;

import com.xja.ssm.entity.SysMenu;
import com.xja.ssm.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);
    //根据rolename区查询有无相同的名字做验证
    SysRole selectByName(String rolename);
    
    List<SysMenu> selectByroleid(Integer id);
    
    
    
    List<SysRole> selectList();

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}