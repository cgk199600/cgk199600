package com.xja.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xja.ssm.common.CipherUtil;
import com.xja.ssm.common.JsonBean;
import com.xja.ssm.dao.SysMenuMapper;
import com.xja.ssm.dao.SysUserMapper;
import com.xja.ssm.entity.SysUser;
import com.xja.ssm.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {
@Autowired
private SysUserMapper sysusermapper;
@Autowired
private SysMenuMapper sysMenuMapper;
	@Override
	public JsonBean insertuser(SysUser user) {
		SysUser dbuser=sysusermapper.selectByUserName(user.getPhone());//根据电话查询用户名
		if(dbuser!=null) {
			return new JsonBean(1,"该手机号已注册",null);
		}
		// TODO Auto-generated method stub
		//Username的值为phone和phone不能出现重复
		user.setUsername(user.getPhone());
		//Password得值为默认（123456+username）+salt
		//调用创建盐的方法
		String salt=CipherUtil.createSalt();
		//11，调用加密方法加密默认密码
		String pwd=CipherUtil.generatePassword("123456");
		//12，使用密码，盐，用户名进行两次迭代（加密），生成最终的密码
		String password=CipherUtil.createPwdEncrypt(user.getUsername(), pwd, salt);
		//13，把盐set进去，把密码set进去
		user.setPassword(password);
		user.setSalt(salt);
		int i=sysusermapper.insert(user);
		if(i>0) {
			return new JsonBean(0,"添加成功",null);
		}
		return new JsonBean(-1,"添加异常",null);
	}
	@Override
	public JsonBean selectTableList() {
		// TODO Auto-generated method stub
		return new JsonBean(0,"ok",sysusermapper.selectList()) ;
	}
	@Override
	public JsonBean selectByUsername(String username, String password) {
		// TODO Auto-generated method stub
		SysUser dbuser = sysusermapper.selectByUserName(username);
		System.out.println(dbuser.toString()+"////////////////");
		System.out.println(password+"=============");
		JsonBean jsonbean=new JsonBean(-3,"用户名或密码错误",null);
		
		if(dbuser!=null) {//判断用户名
			if(!dbuser.getStatus().equals("0")){//判断权限
				return new JsonBean(-4,"用户没有权限",null);
			}
			//CipherUtil.createPwdEncrypt(username, password, dbuser.getSalt())
			if(dbuser.getPassword().equals(password)) {//判断密码
				  Map<String, Object> getmenuByroleId = getmenuByroleId(dbuser.getroleId());//调下面的查询菜单的方法
				dbuser.setMenu(getmenuByroleId);//传入数据
				return new JsonBean(0,"ok",dbuser);
			}
		}
	
		return jsonbean;
	}
	
	@Override
	public Map<String,Object> getmenuByroleId(Integer roleId) {
		// TODO Auto-generated method stub
		Map<String,Object> resultMap=new HashMap<String, Object>();//new一个map
		List<Map<String,Object>> byroleId = sysMenuMapper.selectUserByroleId(roleId);
		resultMap.put("firstMenu", byroleId);//一级菜单传入map实行便利
		for (Map<String, Object> map : byroleId) {//便利查询的菜单map
			List<Map<String,Object>> list =sysMenuMapper.selectmenuBypid(Integer.valueOf(map.get("id").toString()));//把查询出来的pid转为int类型传给查询下级菜单
			List<Map<String,Object>> forlist=forList(list);//如果还有下级菜单进入递归传给map集合
			resultMap.put(map.get("remark").toString(), forlist);//map get出remark一级菜单的备注为key,forlist为查询出的值
			
		}
		return resultMap;
	}

	//查询下级菜单的递归
	private List<Map<String,Object>> forList(List<Map<String,Object>> list){
		
		for (Map<String, Object> map : list) {//便利
			List<Map<String,Object>> list2 =sysMenuMapper.selectmenuBypid(Integer.valueOf(map.get("id").toString()));//查询下级菜单
			if(list2.size()!=0) {
			map.put("chiltren", list2);//存入map集合到map中key为chiltren
			forList(list2);//调用自己完成递归已举续查询下一级
			}
		}
		return list;
	}


}
