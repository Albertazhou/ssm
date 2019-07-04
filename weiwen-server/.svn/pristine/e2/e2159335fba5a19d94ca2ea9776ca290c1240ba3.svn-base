package com.cetc.weiwen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.EventChat;
import com.cetc.weiwen.vo.EventChatVo;

@Mapper
public interface EventChatMapper {

    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条群聊消息
     * @param record
     * @return
     */
    int insertChatInfo(EventChat record);
    
    /**
     * 根据事件id读取群消息
     * @return
     */
    List<EventChatVo> getEventChatByEventId(Integer eventId);
    
    /**
     * 根据事件id和(小于)消息id读取群消息
     * @return
     */
    List<EventChatVo> getEventChatByEventIdAndSmllerChatId(@Param("eventId")Integer eventId,@Param("chatId")Integer chatId);
    
    /**
     * 根据事件id和(大于)消息id读取群消息
     * @return
     */
    List<EventChatVo> getEventChatByEventIdAndBiggerChatId(Integer eventId);

   
}