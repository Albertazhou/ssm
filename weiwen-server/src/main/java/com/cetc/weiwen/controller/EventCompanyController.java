package com.cetc.weiwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventCompanyService;

/**
 * 事件与公司联合表的控制层
 * @author jhl
 * @date 2018年8月9日 下午5:18:05
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/eventCompany")
public class EventCompanyController {
	
	@Autowired
	private EventCompanyService eventCompanyService;

	/**
	 * 获取事件与公司的信息列表
	 * @param eventId
	 * @param companyId
	 * @param type
	 * @return
	 */
	@GetMapping(produces= {"application/json;charset=UTF-8"})
	public Result<Object> getEventCompanyList(
			@RequestParam(name="eventId",required=false)Integer eventId,
			@RequestParam(name="companyId",required=false)Integer companyId){
		EventCompany eventCompany = new EventCompany();
		
		eventCompany.setEventId(eventId);
		eventCompany.setCompanyId(companyId);
		List<EventCompany> eventCompanyList = eventCompanyService.getEventCompanyList(eventCompany);
		if(eventCompanyList.size() > 0) {
			return Result.success(eventCompanyList);
		}else {
			return Result.errorMsg("没有相关的信息列表");
		}
	}
	
	/**
	 * 插入事件与公司的关联信息
	 * @param eventCompany
	 * @return
	 */
	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> insertEventCompany(
			@RequestBody EventCompany eventCompany){
		int num = eventCompanyService.insertEventCompany(eventCompany);
		if(num > 0) {
			return Result.success("插入公司成功！");
		}else {
			return Result.errorMsg("插入公司失败！");
		}
	}
	
	/**
	 * 删除公司与事件的关联信息
	 * @param eventId
	 * @param companyId
	 * @return
	 */
	@DeleteMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> deleteEventCompany(
			@RequestParam(name="eventId",required=true)Integer eventId,
			@RequestParam(name="companyId",required=true)Integer companyId){
		EventCompany eventCompany = new EventCompany();
		eventCompany.setEventId(eventId);
		eventCompany.setCompanyId(companyId);
		int num = eventCompanyService.deleteEventCompany(eventCompany);
		if(num > 0) {
			return Result.success("删除公司成功！");
		}else {
			return Result.errorMsg("删除公司失败！");
		}
	}
}
