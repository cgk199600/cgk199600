package com.xja.ssm.service;

import com.xja.ssm.common.JsonBean;
import com.xja.ssm.entity.Users;

public interface UsersService {
	JsonBean insertUsers(Users users);
	JsonBean deleteUsers(Integer id);
	JsonBean updatetUsers(Users users);
	JsonBean selectusers();
	Users selectByid(Integer id);
	JsonBean selectByidjosn(Integer id);

}
