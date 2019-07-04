package com.cetc.weiwen.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.EventChatService;
import com.cetc.weiwen.service.EventService;
import com.cetc.weiwen.service.EventUserService;
import com.cetc.weiwen.vo.EventChatVo;

@RestController
@RequestMapping("/eventChat")
public class ChatController {
	@Autowired
	private EventChatService  chatInfoService;
	
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private EventUserService eventUserService;
	
	/**
	 * 发送群消息
	 * @param chatInfo
	 * @return
	 * @throws IOException 
	 */
	@PostMapping(produces = {"application/json;charset=UTF-8" })
	public Result<String> sendChatInfo(@RequestParam(name="file",required=false)MultipartFile file,
			@RequestParam(name="eventId",required=true) Integer eventId,
			@RequestParam(name="userId",required=true) Integer userId,
			@RequestParam(name="content",required=false) String content,
			@RequestParam(name="type",required=false) Integer type,
			@RequestParam(name="label",required=false) Integer label) throws IOException{ 
		
		if(chatInfoService.sendChatInfo( file,  eventId, userId, content, type, label)<0) {
			return Result.errorMsg("发送失败");
		}
		return Result.success("发送成功");
		
	}
	
	/**
	 * 获取群消息列表
	 * @param pageNum
	 * @param pageSize
	 * @param eventId
	 * @return
	 */
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	public Result<List<EventChatVo>> getEventChatInfo(@RequestParam(name = "pageNum", required = false) Integer pageNum,
			@RequestParam(name = "pageSize", required = false) Integer pageSize,
			@RequestParam(name = "eventId", required = true) Integer eventId,
			@RequestParam(name = "userId", required = true) Integer userId,
			@RequestParam(name = "chatId", required = true) Integer chatId) {
		
		
		List<EventChatVo> chatInfosPag = chatInfoService.getEventChatByEventId(eventId,chatId);
		
		//将用户的已读消息数更新为全部已读
		EventUser eventUser=new EventUser();
		eventUser.setEventId(eventId);
		eventUser.setUserId(userId);
		eventUser.setReadNumber(eventService.queryEventById(eventId).getChatTotal());
		eventUserService.updateEventUserById(eventUser);
		
		return Result.success(chatInfosPag);
	}
	/**获取最新聊天信息
	 * 
	 * @param eventId
	 * @param userId
	 * @param chatId
	 * @return
	 */
	@GetMapping(value = "/newChats",produces = { "application/json;charset=UTF-8" })
	public Result<List<EventChatVo>> getNewEventChatInfo(
			@RequestParam(name = "eventId", required = true) Integer eventId,
			@RequestParam(name = "userId", required = true) Integer userId
			){
		
		List<EventChatVo> chats=chatInfoService.getEventChatByEventIdAndBiggerChatId(eventId);
		
		return Result.success(chats);
		
		
	}
	
	

}
