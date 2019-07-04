package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.vo.EventUserVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventUserMapper {
	
	/**
	 * 插入事件与用户的关系
	 * @param record
	 * @return
	 */
    int insertEventUser(EventUser record);

    int insertSelective(EventUser record);

    /**
     * 获取事件与用户的列表
     * @param eventUser
     * @return
     */

    List<EventUserVo> getEventUserVoByEventUser(EventUser eventUser);
    
    /**
     * 修改事件与用户的相关状态
     * @param eventUser
     * @return
     */
    int updateEventUserById (EventUser eventUser);

    List<EventUserVo> getEventUserVoListByEventUser(EventUser eventUser);

    
    /**
     * 获取事件与用户的关系
     * @param eventUser
     * @return
     */
     EventUserVo getEventUserVo(EventUser eventUser);
    
    /**
     * 根据事件id和用户id查询
     * @param eventUser
     * @return
     */
    EventUser queryEventUserById(EventUser eventUser);
    
	int batchInsertEventUser(List<EventUser> addEventUser);
    
	int batchDelteEventUser(@Param("eventId")Integer id, @Param("ids")List<Integer> delIds);
}