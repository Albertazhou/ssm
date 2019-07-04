package com.cetc.weiwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventUserService;
import com.cetc.weiwen.vo.EventUserVo;

/**
 * 获取事件列表
 * @author jhl
 * @date 2018年8月6日 上午10:54:35
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/eventuser")
public class EventUserController {

	@Autowired
	private EventUserService eventUserService;
	
	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> insertEventUser(
			@RequestBody EventUser eventUser){
		return null;
	}
	
}
