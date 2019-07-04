package com.cetc.weiwen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.commons.utils.RedisGetUser;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.SmsService;
import com.cetc.weiwen.vo.SmsParam;

/**发送短信接口
 * 
 * @author liqiaofei
 * 2018年9月26日
 */
@RestController
@RequestMapping(value = "/sms")
public class SmsController {

	@Autowired
	private SmsService smsService;
	@PostMapping
	private Result<String> sendSms(@Validated @RequestBody SmsParam smsParam,@RequestHeader(value="token")String requestToken){
		User user= RedisGetUser.getUserByRedis(requestToken);
		if(user==null) {
			return Result.errorMsg("非法用户");
		}
		int code =smsService.sendSms(smsParam,user.getId());
		if(code>0) {
			return Result.successMsg("短信发送成功");
		}
		return Result.errorMsg("短信发送失败");
	}
}
