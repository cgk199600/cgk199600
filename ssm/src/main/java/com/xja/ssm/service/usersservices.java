package com.xja.ssm.service;



import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.User;


public interface usersservices {
	JsonBean deleteuser(Integer id);
	JsonBean selectuser(Integer id);
	JsonBean updateuser(User users);
	JsonBean adduser(User users);
	JsonBean selectUsers();
	
}
