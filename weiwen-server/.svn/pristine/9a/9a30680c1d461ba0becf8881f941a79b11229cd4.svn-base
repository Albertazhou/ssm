package com.cetc.weiwen.service;

import java.util.List;

import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.vo.EventCivicsVo;

public interface EventCivicsService {

	/**
	 * 插入事件与公民信息的联合信息
	 * @param record
	 * @return
	 */
    int insertEventCivics(EventCivics eventCivics);

    /**
     * 存在判断语句，插入信息
     * @param cventCivics
     * @return
     */
    int insertEventCivicsPart(EventCivics cventCivics);
    
    /**
     * 获取事件与公民联合列表信息
     * @param cventCivics
     * @return
     */
    List<EventCivicsVo> queryEventVoList(EventCivics eventCivics);
    
    /**
     * 批量添加信息
     * @param eventCivicsList
     * @return
     */
    int batchInsertEventCiv(List<EventCivics> eventCivicsList,int eventId); 
    
    /**
     * 获取事件与用户的关系列表
     * @param eventCivics
     * @return
     */
    List<EventCivics> getEventCivicsList(EventCivics eventCivics);
}
