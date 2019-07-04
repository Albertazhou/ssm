//package com.cetc.weiwen.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cetc.weiwen.result.Result;
//import com.cetc.weiwen.service.EventTypeFunctionTypeService;
//
///**
// * 事件类型与组织架构类型关联表控制层
// * @author jhl
// * @date 2018年8月31日 下午2:20:59
// * @version 1.0 
// *
// */
//@RestController
//@RequestMapping(value="/eventtypefuntype")
//public class EventTypeFunctionTypeController {
//
//	@Autowired
//	private EventTypeFunctionTypeService eventFunTypeService;
//	
//	/**
//	 * 根据事件类型获取组织机构
//	 * @param district
//	 * @param adcode
//	 * @param eventTypeId
//	 * @return
//	 */
//	@GetMapping(produces= {"application/json;charset=UTF-8"})
//	public Result<Object> getFuntionByEventType(
//			@RequestParam(name="adcode",required=true)String adcode,
//			@RequestParam(name="eventTypeId",required=true)Integer eventTypeId){
//		List<Map<String,Object>> mapList = eventFunTypeService.getFuntionByEventType(adcode,eventTypeId);
//		if(mapList.size() > 0) {
//			return Result.success(mapList);
//		}else {
//			return Result.errorMsg("没有获取到相关的组织");
//		}
//	}
//}
