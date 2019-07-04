package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.vo.EventVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 事件持久层
 * @author jhl
 * @date 2018年9月4日 上午11:01:31
 * @version 1.0 
 *
 */
@Mapper
public interface EventMapper {

    int insertEvent(Event record);

    /**
     * 根据事件id获取事件信息
     * @param id
     * @return
     */
    Event queryEventById(Integer id);
    
    /**
     * 根据id进行更新时间
     * @param record
     * @return
     */
    int updateEventById(Event record);
    /**
     * 
     * @param order
     * @param userId
     * @return
     */
	List<EventVo> getEventListOrder(Integer order, Integer userId);
	//获取所有的事件id
	List<Integer> findAllEventId();
	
	//查找 该用户需要审核的事件
	List<Event> findUnReviewedEvent(Integer userId);
    
}