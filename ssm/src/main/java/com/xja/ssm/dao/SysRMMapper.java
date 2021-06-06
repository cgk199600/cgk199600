package com.xja.ssm.dao;

import com.xja.ssm.entity.SysRM;

public interface SysRMMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRM record);

    int insertSelective(SysRM record);

    SysRM selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRM record);

    int updateByPrimaryKey(SysRM record);
}