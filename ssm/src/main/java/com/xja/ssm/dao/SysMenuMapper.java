package com.xja.ssm.dao;

import java.util.List;
import java.util.Map;

import com.xja.ssm.entity.SysMenu;
import com.xja.ssm.resultObj.ZtreeNodes;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);
    //传类根据其中的pid来查
    List<SysMenu> selectmenuListbypid(SysMenu sysmenu);
    //根据roleid查询所有的menuID和权限
    List<ZtreeNodes> selectTreeObj(Integer roleid);
    //根据roleid查询菜单
    List<Map<String,Object>> selectUserByroleId(Integer roleId);
    //查询下级节点
    List<Map<String,Object>> selectmenuBypid(Integer pid);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}