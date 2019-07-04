package com.cetc.weiwen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventOrganizationService;

/**
 * 事件与组织机构联合控制层
 * @author jhl
 * @date 2018年8月9日 下午5:17:35
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/eventOrg")
public class EventOrganizationController {
	
	@Autowired
	private EventOrganizationService eventOrgService;

	/**
	 * 添加事件与组织机构的关系
	 * @param eventOrg
	 * @return
	 */
	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> insertEventOrg(
			@RequestBody EventOrganization eventOrg){
		
		int num = eventOrgService.insertEventOrg(eventOrg);
		
		if(num > 0) {
			return Result.success("添加公司成功！");
		}else {
			return Result.errorMsg("添加公司失败！");
		}
	}
	
	/**
	 * 删除事件与组织机构的关联信息
	 * @param eventOrg
	 * @return
	 */
	@DeleteMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> deleteEventOrg(
			@RequestBody EventOrganization eventOrg){
		int num = eventOrgService.deleteEventOrg(eventOrg);
		if(num > 0) {
			return Result.success("删除成功！");
		}else {
			return Result.errorMsg("删除失败！");
		}
	}
}
