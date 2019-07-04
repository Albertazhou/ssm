package com.cetc.weiwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventCivicsService;
import com.cetc.weiwen.vo.EventCivicsVo;

@RestController
@RequestMapping("/eventcivics")
public class EventCivicsController {

	@Autowired
	private EventCivicsService eventCivicsService;
	
	/**
	 * 根据公民身份证获取事件列表
	 * @param idcard
	 * @return
	 */
	@GetMapping(produces= {"application/json;charset=UTF-8"})
	public Result<Object> queryEventCivicsList(
			@RequestParam(name="idcard",required=false)String idcard,
			@RequestParam(name="eventId",required=false)Integer eventId){
		EventCivics eventCivics = new EventCivics();
		eventCivics.setIdcard(idcard);
		eventCivics.setEventId(eventId);
		List<EventCivics> eventCivicsList = eventCivicsService.getEventCivicsList(eventCivics);
		if(eventCivicsList.size() > 0) {
			return Result.success(eventCivicsList);
		}else {
			return Result.errorMsg("没有涉稳事件");
		}
	}
}
