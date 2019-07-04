package com.cetc.weiwen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventProcess;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventProcessService;

@RestController
@RequestMapping("/eventprocess")
public class EventProcessController {

	@Autowired
	private EventProcessService eventProcessService;
	
	/**
	 * 根据id或者事件id查询事件流程
	 * @param id
	 * @param eventId
	 * @return
	 */
	@GetMapping(produces= {"application/json;charset=UTF-8"})
	public Result<Object> getEventProcess(
			@RequestParam(name="eventId",required=true)Integer eventId){
		EventProcess eventProcess = new EventProcess();
		
		eventProcess.setEventId(eventId);
		
		EventProcess ep = eventProcessService.queryEventProcess(eventProcess);
		
		if(ep != null) {
			return Result.success(ep);
		}else {
			return Result.errorMsg("不存在该事件！");
		}
	}
	
	/**
	 * 获取详细流程信息
	 * @param id
	 * @param eventId
	 * @return
	 */
	@GetMapping(value="/processlist",produces={"application/json;charset=UTF-8"})
	public Result<Object> getEventProcessList(
			@RequestParam(name="eventId",required=true)Integer eventId){
		EventProcess eventProcess = new EventProcess();
		eventProcess.setEventId(eventId);
		List<Map<String, Object>> mapList = eventProcessService.getEventProcessList(eventProcess);
		if(mapList.size() > 0) {
			return Result.success(mapList);
		}else {
			return Result.errorMsg("不存在该事件的流程信息。");
		}
	}
}
