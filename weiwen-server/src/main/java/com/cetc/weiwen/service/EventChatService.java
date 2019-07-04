package com.cetc.weiwen.service;


import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.cetc.weiwen.entity.EventChat;
import com.cetc.weiwen.vo.EventChatVo;
import com.cetc.weiwen.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface EventChatService {
	
	/**
     * 发送一条群聊消息
     * @param record
     * @return
     */
	int sendChatInfo(MultipartFile file, Integer eventId, Integer userId, String content, Integer type, Integer label)throws IOException;
    
    
    /**
     * 根据事件id读取群消息
     * @return
     */
    List<EventChatVo> getEventChatByEventId(Integer eventId,Integer chatId);
    
    List<EventChatVo> getEventChatByEventIdAndBiggerChatId(Integer eventId);
	
}
