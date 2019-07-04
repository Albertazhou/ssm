package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.vo.EventCivicsVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 公民与事件关联
 * @author jhl
 * @date 2018年9月4日 上午10:57:58
 * @version 1.0 
 *
 */
@Mapper
public interface EventCivicsMapper {

    int insert(EventCivics record);

    int insertSelective(EventCivics record);
    
    /**
     * 获取公民与事件的关联列表
     * @param eventCivics
     * @return
     */
    List<EventCivicsVo> getEventCivicsVoList(EventCivics eventCivics);

    /**
     *根据事件id获取事件与用户的列表信息
     * @param eventId
     * @return
     */
	List<EventCivics> queryEventCivicsList(EventCivics eventCivics);
}