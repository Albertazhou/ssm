package com.cetc.weiwen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.EventLevelContrast;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventLevelContrastService;

/**
 * 事件级别对照Controller类
 * 
 * @author liqiaofei
 * 
 */
//@RestController
//@RequestMapping("/eventLevelContrast")
//public class EventLevelContrastController {
//
//	@Autowired
//	private EventLevelContrastService eventLevelContrastService;
//
//	/**
//	 * 获取事件级别信息列表
//	 * @param num
//	 * @param size
//	 * @param eventTypeId
//	 * @param peopleNumId
//	 * @return
//	 */
//	@GetMapping(produces = { "application/json;charset=UTF-8" })
//	public Result<Map<String,Object>> getEventLevelContrastLists(
//			@RequestParam(name = "num", required = false) Integer num,
//			@RequestParam(name = "size", required = false) Integer size,
//			@RequestParam(name = "eventTypeId", required = false) Integer eventTypeId,
//			@RequestParam(name = "peopleNumId", required = false) Integer peopleNumId) {
//
//		Map<String,Object> elMap = eventLevelContrastService.getEventLevelContrastLists(num, size, eventTypeId,
//				peopleNumId);
//		return Result.success(elMap);
//	}
//
//	/**
//	 * 更新事件级别对照数据
//	 * @param id
//	 * @param eventLevelContrast
//	 * @return
//	 */
//	
//	@PutMapping(value = "/{id}", produces = { "application/json;charset=UTF-8" })
//	public Result<String> updateEventLevelContrast(@PathVariable(name = "id", required = true) Integer id,
//			@RequestBody EventLevelContrast eventLevelContrast) {
//		eventLevelContrast.setId(id);
//		int code = eventLevelContrastService.updateEventLevelContrast(eventLevelContrast);
//		if (code == 1) {
//			return Result.success("更新成功");
//		} else if (code == -1) {
//			return Result.errorMsg("参数异常");
//		}
//
//		return Result.errorMsg("更新失败");
//	}
//    /**
//     * 添加事件级别对照数据
//     * @param eventLevelContrast
//     * @return
//     */
//	@PostMapping(produces = { "application/json;charset=UTF-8" })
//	public Result<String> addEventLevelContrast(@RequestBody EventLevelContrast eventLevelContrast) {
//
//		int code = eventLevelContrastService.addEventLevelContrast(eventLevelContrast);
//
//		if (code == 1) {
//			return Result.success("添加成功");
//		} else if (code == -1) {
//			return Result.errorMsg("参数异常");
//		}
//		return Result.errorMsg("添加失败");
//	}
//    /**
//     * 删除事件级别对照数据
//     * @param id
//     * @return
//     */
//	@DeleteMapping(value = "/{id}", produces = { "application/json;charset=UTF-8" })
//	public Result<String> deleteEventLevelContrast(@PathVariable(name = "id", required = true) Integer id) {
//		int code = eventLevelContrastService.deleteEventLevelContrast(id);
//		if (code == 1) {
//			return Result.success("删除成功");
//		} 
//		return Result.errorMsg("删除失败");
//	}
//}
