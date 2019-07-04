package com.cetc.weiwen.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.commons.constant.Constant;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.UserService;
/**web和app用户的登录退出操作控制器
 * 
 * @author liqiaofei
 * 2018年9月19日
 */
@RestController
public class LogController {
	@Autowired
	private UserService userService;
	
	
	/**
	 * app用户登录 
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/app/login", produces = { "application/json;charset=UTF-8" })
	public Result<User> appLogin(@RequestBody User user) {
		
		User data=userService.login( user,Constant.USER_APP_PREFIX,Constant.USER_TOKEN_APP_PREFIX);
		if(data==null) {
			return Result.errorMsg("登录失败");
		}
		return Result.success(data);
	}

	/**
	 * web用户登录 
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/web/login", produces = { "application/json;charset=UTF-8" })
	public Result<User> webLogin(@RequestBody User user) {
		User data=userService.login( user,Constant.USER_WEB_PREFIX,Constant.USER_TOKEN_WEB_PREFIX);
		if(data==null) {
			return Result.errorMsg("登录失败");
		}
		return Result.success(data);
	}

	// web用户退出登录
	@DeleteMapping(value = "/web/logout/{id}", produces = { "application/json;charset=UTF-8" })
	public Result<String> webLogout(@PathVariable(name = "id", required = true) Integer id,
			HttpServletRequest request) {
		// 获取用户token
		String token1 = RedisUtils.get(Constant.USER_WEB_PREFIX + id,String.class);
		String token2 = request.getHeader("token");
		int code =userService.logout(token1,token2,id,Constant.USER_WEB_PREFIX,Constant.USER_TOKEN_WEB_PREFIX);
		if(code==1) {
			return Result.successMsg("注销成功");
		}
		return Result.errorMsg("注销失败");
	}

	// app用户退出登录
	@DeleteMapping(value = "/app/logout/{id}", produces = { "application/json;charset=UTF-8" })
	public Result<String> appLogout(@PathVariable(name = "id", required = true) Integer id,
			HttpServletRequest request) {
		// 获取用户token
		String token1 = RedisUtils.get(Constant.USER_APP_PREFIX + id,String.class);
		// 判断用户token与请求头token是否一致
		String token2 = request.getHeader("token");
		int code =userService.logout(token1,token2,id,Constant.USER_APP_PREFIX,Constant.USER_TOKEN_APP_PREFIX);
		if(code==1) {
			return Result.successMsg("注销成功");
		}
		return Result.errorMsg("注销失败");
	}
}
