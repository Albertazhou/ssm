package com.cetc.weiwen.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.commons.utils.RedisGetUser;
import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventService;
import com.cetc.weiwen.vo.EventReceive;
import com.cetc.weiwen.vo.EventVo;

@RestController
@RequestMapping(value="/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@DeleteMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> deleteEvent(
			@RequestParam(name="id",required=true)Integer id,
			@RequestParam(name="chatStatus",required=false)Integer chatStatus){
		int num = eventService.deleteEventById(id,chatStatus);
		if(num > 0) {
			return Result.success("操作成功！");
		}else {
			return Result.errorMsg("操作失败！");
		}
	}
	
	/**
	 * 新建事件
	 * @param event
	 * @return
	 */
	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> createEvent(@RequestBody EventReceive eventReceive,
			@RequestHeader(value="token")String requestToken){
		User user= RedisGetUser.getUserByRedis(requestToken);
		int num = eventService.createEvent(eventReceive,user);
		if(num > 0) {
			return Result.success("新建事件成功！");
		}else {
			return Result.errorMsg("新建事件失败！");
		}
	}
	
	/**
	 * 更新事件
	 * @param event
	 * @return
	 */
	@PutMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> updateEvent(@RequestBody EventReceive eventReceive,
			@RequestHeader(value="token")String requestToken){
		User user= RedisGetUser.getUserByRedis(requestToken);
		int num = eventService.updateEvent(eventReceive,user);
		if(num > 0) {
			return Result.success("更新事件成功！");
		}else if(num == -2){
			return Result.errorMsg("不存在该事件！");
		}else {
			return Result.errorMsg("更新事件失败，请检查提交的信息！");
		}
	}
	
	/**
	 *  获取事件详情
	 * @param eventId
	 * @return
	 */
	@GetMapping(value="/{eventId}/detail",produces= {"application/json;charset=UTF-8"})
	public Result<Object> getEventDetailInfo(
			@PathVariable(value="eventId",required=true)Integer eventId){
		Map<String, Object> map = eventService.getEventDetailInfo(eventId);
		if(map != null) {
			return Result.success(map);
		}else {
			return Result.errorMsg("没有该事件的相关信息！");
		}
	}
	
	/**
	 *   根据特定排序规则，返回事件列表(首页信息)
	 * 0表示按时间排序，1表示按级别排序，2表示按事件类型排序
	 * @param eventId
	 * @return
	 */
	@GetMapping(value="/todo",produces= {"application/json;charset=UTF-8"})
	public Result<List<EventVo>> getEventListOrder(@RequestParam(value="order",required=true)Integer order,@RequestHeader(value="token")String requestToken){
		User user= RedisGetUser.getUserByRedis(requestToken);
		Integer userId=user.getId();
		List<EventVo> eventVoList = eventService.getEventListOrder(order,userId);
		
		return  Result.success(eventVoList);
	}
	
	/**
	 * 根据事件名称查询用户相关的事件
	 * 
	 * @return
	 */
	@GetMapping(value = "/list/{name}", produces = { "application/json;charset=UTF-8" })
	public Result<List<Event>> getUserEvent(@PathVariable(name = "name", required = false) String name,@RequestHeader(value="token")String token) {
		User user=RedisGetUser.getUserByRedis(token);
		if(user==null) {
			return Result.errorMsg("token过期");
		}
		List<Event> list = eventService.getUserEvent(name,user.getId());
		return Result.success(list);
	}
	
	
	/**
	 *  对事件进行置顶操作
	 * top等于0表示将eventId对应事件取消置顶
	 * top等于1表示将eventId对应事件置顶
	 * @param eventId
	 * @param top
	 * @return
	 */
	@PutMapping(value="/top",produces= {"application/json;charset=UTF-8"})
	public Result<String> setEventTop(@RequestParam(value="top",required=true)Long top,
			@RequestParam(value="eventId",required=true)Integer eventId,@RequestHeader(value="token")String requestToken){
		User user= RedisGetUser.getUserByRedis(requestToken);
		Integer userId=user.getId();
		Integer code = eventService.setEventTop(eventId,top,userId);
		if(code>0) {
		  if(top.equals(0L)) {
			  return  Result.success("取消置顶成功");
		  }
		  return  Result.success("置顶成功");
		}
		 return  Result.errorMsg("操作失败");
	}
}
