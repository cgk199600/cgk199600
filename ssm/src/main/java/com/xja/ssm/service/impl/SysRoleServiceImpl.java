package com.xja.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.SysRMMapper;
import com.xja.ssm.dao.SysRoleMapper;
import com.xja.ssm.entity.SysMenu;
import com.xja.ssm.entity.SysRM;
import com.xja.ssm.entity.SysRole;
import com.xja.ssm.service.RoleService;
@Service
public class SysRoleServiceImpl implements RoleService {
@Autowired
private SysRoleMapper sysRoleMapper;
@Autowired
private SysRMMapper SysRMMapper;
	@Override//查询所有LIst
	public JsonBean selectList() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",sysRoleMapper.selectList());
	}
	@Override
	public JsonBean insertrole(SysRole role) {
		//1，先添加角色信息加色添加成功后返回主键的ID
		//2,根据角色主键ID和传入的IDS进行r_m添加
		JsonBean JsonBean= new JsonBean(-1,"失败",null);
		SysRole m=sysRoleMapper.selectByName(role.getRolename());
		if(m!=null) {//判断是否存在角色
			JsonBean= new JsonBean(1,"角色已存在",null);
		}else {
		int i=sysRoleMapper.insert(role);

		if(i>0) {
			/*一对多关系
			 * 一个角色拥有多个权限
			 * for循环完成添加
			 * mabatis完成添加
			 */
			 String[] ids=role.getIds().split(",");//现在role类中添加ids的属性再利用返回主键的方法添加到关联表中
			 for (int j=0 ;j<ids.length; j++) {
				SysRM sysrm=new SysRM();
				sysrm.setMenuId(Integer.valueOf(ids[j]));//添加ids值到关联表中
				sysrm.setRoleId(role.getId());//附roleid得值
				SysRMMapper.insert(sysrm);//添加关联关系
			}
			 JsonBean = new JsonBean(0,"成功",null);
		}
			
		
		}
		return JsonBean;
	}
	
	@Override
	public JsonBean selectByName(String rolename) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JsonBean getdatabyid(Integer id) {
		// TODO Auto-generated method stub
		SysRole role = sysRoleMapper.selectByPrimaryKey(id);
		List<SysMenu> menu = sysRoleMapper.selectByroleid(id);//通过连接表查询出role所属于的menu
		String mName="";
		String ids="";
		for (SysMenu sysMenu : menu) {//便利出来添加到ids和mName中
			mName +=sysMenu.getTitle()+"|";
			ids+=sysMenu.getId()+",";
		}
		role.setIds(ids.substring(0,ids.length()-1));//set给 role中,role要写接收的ids和mname
		role.setmName(mName.substring(0,mName.length()-1));//把他们的|和,都截取掉
		return new JsonBean(0,"ok",role);
	}
	
	@Override
	public JsonBean updaterole(SysRole role) {
		// TODO Auto-generated method stub
		JsonBean jsonBean = new JsonBean(-1,"修改失败",null);
		/*
		 * 修改role表时中间表可能会有增加删除权限等操作
		
		 * 操作不同的表添加，删除，修改，都在同一个方法中，业务要保证事务操作
		 */
		//所以先修改role表中的name和status
		int i=sysRoleMapper.updateByPrimaryKeySelective(role);
		if(i>0) {
			//再根据roleID删除rm表中数据
			int k = SysRMMapper.deleteByPrimaryKey(role.getId());//先删除再添加
			//再放入role表ID和新授权的菜单的ID，进行添加
			 String[] ids=role.getIds().split(",");//现在role类中添加ids的属性再利用返回主键的方法添加到关联表中
			 for (int j=0 ;j<ids.length; j++) {
				SysRM sysrm=new SysRM();
				sysrm.setMenuId(Integer.valueOf(ids[j]));//添加ids值到关联表中
				sysrm.setRoleId(role.getId());//附roleid得值
				SysRMMapper.insert(sysrm);//添加关联关系
			}
			 jsonBean = new JsonBean(0,"修改成功",null);
		}
		return jsonBean;
	}

}
