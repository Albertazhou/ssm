package com.cetc.weiwen.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.commons.constant.Constant;
import com.cetc.weiwen.commons.constant.PushType;
import com.cetc.weiwen.commons.utils.FileOperationUtils;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.entity.ChatContent;
import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventChat;
import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.entity.PushMessage;
import com.cetc.weiwen.mapper.EventChatMapper;
import com.cetc.weiwen.mapper.EventMapper;
import com.cetc.weiwen.mapper.EventUserMapper;
import com.cetc.weiwen.mapper.UserMapper;
import com.cetc.weiwen.service.EventChatService;
import com.cetc.weiwen.service.ImageService;
import com.cetc.weiwen.vo.EventChatVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EventChatServiceImpl implements EventChatService {
	
	private final Logger logger = LoggerFactory.getLogger(EventChatServiceImpl.class);
	
	@Autowired
	private EventChatMapper eventChatMapper;

	@Autowired
	private EventMapper eventMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	EventUserMapper eventUserMapper;
	
	@Autowired
    private ImageService imageService;
	
	@Transactional
	@Override
	public int sendChatInfo(MultipartFile file, Integer eventId, Integer userId, String content, Integer type, Integer label) throws IOException{
		// TODO Auto-generated method stub
		EventChat eventChat=new EventChat();
		eventChat.setEventId(eventId);
		eventChat.setUserId(userId);
		eventChat.setCreateTime(new Date(System.currentTimeMillis()));
		ChatContent chatContent=null;
		//上传聊天文件
		if(file!=null) {
			String fullStrAddr= FileOperationUtils.saveFile(file);
			switch (type) {
			case 1://1：表示语音聊天
				chatContent=setChatContent( content,  type,  label);
				break;
			case 3://3：表示图片聊天--->图片标签化
				chatContent=setChatContent( fullStrAddr,type, label);
				imageService.imagelabeling(fullStrAddr,type,label,eventId,userId);
				break;
			case 4://4： 表示文件
				chatContent=setChatContent( content,  type,  label);
				break;
			case 5://5: 表示视频文件
				chatContent=setChatContent( content,  type,  label);
				break;
			case 6://6: 页面跳转
				chatContent=setChatContent( content,  type,  label);
				break;
			default:
				//如果没有正确传入type默认为上传文件
				chatContent=setChatContent( fullStrAddr,  4,  label);
				break;
			}
	        eventChat.setContent(JSON.toJSONString(chatContent));
		}else {
		    //文字聊天-->case 2://2：表示文字聊天-->todo
			chatContent=setChatContent( content,  2,  label);
			eventChat.setContent(content);
		}
		Date nowDate = new Date(System.currentTimeMillis());

		Event oldEvent = eventMapper.queryEventById(eventChat.getEventId());
		Event event = new Event();
		event.setId(eventChat.getEventId());
		event.setLastEditTime(nowDate);// 更新事件表中的最新编辑时间
		event.setChatTotal(oldEvent.getChatTotal() + 1);// 更新事件表中的信息总数
		String userRealName = userMapper.getUserById(eventChat.getUserId()).getRealName();
		event.setNewChat(userRealName + ":" + eventChat.getContent());// 更新事件中最新信息
		event.setVersion(oldEvent.getVersion());//乐观锁
		//更新置顶时间
		EventUser newEventUser = new EventUser();
		newEventUser.setEventId(eventChat.getEventId());
		newEventUser.setUserId(eventChat.getUserId());
		EventUser oldEventUser=eventUserMapper.queryEventUserById(newEventUser);
		
		if(oldEventUser.getTopping()!=0L) {
			newEventUser.setTopping(System.currentTimeMillis());
			newEventUser.setVersion(oldEventUser.getVersion());//乐观锁
			//eventUserMapper.updateEventUserById(newEventUser);
			int isSucess=eventUserMapper.updateEventUserById(newEventUser);
			if(isSucess<=0) {
				return -1;
			}
			
		}
	
		if (eventChatMapper.insertChatInfo(eventChat) > 0 && eventMapper.updateEventById(event) > 0) {
			//推送到redis
			PushMessage message=new PushMessage();
			message.setType(PushType.EVENT_CHAT);
			message.setFrom(eventChat.getUserId());
			message.setTo(event.getId());
			message.setContent(eventChat.getContent());
			RedisUtils.pushMessage(Constant.PUSH_SYSTEM, message);
			return eventChat.getId();
		}
		//事务回滚(可能插入成功，更新失败所以回滚)
		logger.info("发送聊天信息事务回滚.............");
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		return -1;
		
	}

	@Override
	public List<EventChatVo> getEventChatByEventId(Integer eventId,Integer chatId) {
		// TODO Auto-generated method stub
		// 分页
//		if (pageNum == null || pageSize == null) {
//			pageNum = 1;
//			pageSize = 2000;
//		}
//		PageHelper.startPage(pageNum, pageSize);
//		PageHelper.orderBy("c.create_time");
//		List<EventChatVo> chatInfos = eventChatMapper.getEventChatByEventIdAndSmllerChatId(eventId, chatId);
//		PageInfo<EventChatVo> pageInfo = new PageInfo<EventChatVo>(chatInfos);
//		return pageInfo;
		
		List<EventChatVo> chatInfos = eventChatMapper.getEventChatByEventIdAndSmllerChatId(eventId, chatId);
		return chatInfos;
		

	}

	@Override
	public List<EventChatVo> getEventChatByEventIdAndBiggerChatId(Integer eventId) {
		// TODO Auto-generated method stub
		return eventChatMapper.getEventChatByEventIdAndBiggerChatId(eventId);
	}
	
	private ChatContent setChatContent(String content, Integer type, Integer label) {
		ChatContent chat =new ChatContent();
		chat.setContent(content);
		chat.setType(type);
		chat.setLabel(label);
		return chat;
	}

}
