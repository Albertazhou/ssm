package com.cetc.weiwen.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.User;

public class UserMapperTest extends WeiwenServerApplicationTest{
	
	
	@Autowired
	private UserMapper UserMapper;
	
	@Test
	public void testFindUserListByEventId() {
		List<User> users=UserMapper.findUserListByEventId(1);
		System.out.println(JSON.toJSONString(users));
	}
}
