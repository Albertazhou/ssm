package com.cetc.weiwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.SyncService;
import com.cetc.weiwen.vo.SynDictionaryVo;

/**
 * 前端app同步数据控制器
 * @author liqiaofei
 * 2018年9月10日
 */
@RestController
@RequestMapping(value="/sync")
public class SyncController {

	@Autowired
	private SyncService syncService;
	
	@GetMapping(produces= {"application/json;charset=UTF-8"}) 
	private Result<SynDictionaryVo> sync(@RequestParam(name="delVId")Integer delVId,
			@RequestParam(name="eventVId", required = true)Integer eventVId,
			@RequestParam(name="eventTypeVId", required = true)Integer eventTypeVId,
			@RequestParam(name="orgVId", required = true)Integer orgVId,
			@RequestParam(name="eventLevelContactVId", required = true)Integer eventLevelContactVId,
			@RequestParam(name="functionTypeVId", required = true)Integer functionTypeVId,
			@RequestParam(name="divisionVId", required = true)Integer divisionVId,
			@RequestParam(name="eventTypeFunctionTypeVId", required = true)Integer eventTypeFunctionTypeVId,
			@RequestParam(name="positionVId", required = true)Integer positionVId){
	   
		SynDictionaryVo syncDV=syncService.sync(delVId, eventVId, eventTypeVId, orgVId, eventLevelContactVId,
				functionTypeVId, divisionVId, eventTypeFunctionTypeVId, positionVId);
		return Result.success(syncDV);
	}
}
