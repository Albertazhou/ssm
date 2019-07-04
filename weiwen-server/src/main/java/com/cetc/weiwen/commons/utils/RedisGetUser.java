package com.cetc.weiwen.commons.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.cetc.weiwen.entity.User;

/**
 * 从redis获取用户信息
 * @author jhl
 * @date 2018年9月13日 上午9:49:15
 * @version 1.0 
 *
 */
public class RedisGetUser {

	
	/**
	 * 通过redis获取用户信息
	 * @param request
	 * @return
	 */
	public static User getUserByRedis(String token) {
	     
		if(!StringUtils.isEmpty(token)) {
			User user =RedisUtils.get(token,User.class);
			return user;
		}
		return null;
	}
}
