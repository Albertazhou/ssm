package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.vo.EventReceive;
import com.cetc.weiwen.vo.EventVo;

public interface EventService {

	/**
	 * 根据id进行删除
	 * @param id
	 * @param chatStatus 
	 * @return
	 */
    int deleteEventById(Integer id, Integer chatStatus);

    /**
     * 新增事件（不存在判空）
     * @param record
     * @return
     */
    int createEvent(EventReceive eventReceive,User user);

    /**
     * 新增事件（存在判空）
     * @param record
     * @return
     */
    int insertPartEvent(Event event);

    /**
     * 根据id进行查询，返回事件对象
     * @param id
     * @return
     */
    Event queryEventById(Integer id);

    /**
     * 通过id进行更新事件
     * @param record
     * @return
     */
    int updateEventById(Event event);
    
    
    /**根据用户id查询事件信息
     * 
     * @param id
     * @return
     */
    List<Event> queryEventByIdAndEventName(Integer id,String name);
    
    /**
     * 审核事件通过id
     * @param id
     * @return
     */
    int updatePassEventByEvent(Event event);
   
    /**
     * 根据组织机构新增事件
     * @param event
     * @param eventOrgList
     * @return
     */
	int insertEventByOrgList(Event event, List<EventOrganization> eventOrgList);

	/**
	 * 更新事件（包括审核和更新事件）
	 * @param event
	 * @param user
	 * @return
	 */
	int updateEvent(EventReceive event, User user);

	/**
	 * 获取审核时的事件信息
	 * @param eventId
	 * @return
	 */
	Map<String, Object> getEventDetailInfo(Integer eventId);
	/*根据不同的排序规则对事件列表进行排序*/
	List<EventVo> getEventListOrder(Integer order, Integer userId);
	/*事件置顶操作*/
	Integer setEventTop(Integer eventId, Long top, Integer userId);
	
	//事件按名称搜索
	List<Event> getUserEvent(String name,Integer userId);
		
}
