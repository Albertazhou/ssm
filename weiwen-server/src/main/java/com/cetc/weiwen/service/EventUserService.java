package com.cetc.weiwen.service;

import java.util.List;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.ResultExecution;
import com.cetc.weiwen.vo.EventUserVo;

/**
 * 事件与用户关联表的业务层
 * @author jhl
 * @date 2018年8月6日 上午10:22:00
 * @version 1.0 
 *
 */
public interface EventUserService {

	/**
	 * 插入事件与用户的联合信息
	 * @param eventUser
	 * @return
	 */
    int insertEventUser(EventUser eventUser);

    /**
     * 插入信息，存在判断语句
     * @param eventUser
     * @return
     */
    int insertPartEventUser(EventUser eventUser);
    
    /**
     * 根据eventuser进行查询
     * @param eventUser
     * @return
     */
    List<EventUserVo> queryEventUserVoByEventUser(EventUser eventUser);
    
    /**
     * 根据用户id获取事件与用户的信息列表
     * @param userId
     * @return
     */
    List<Event> getEventByUserId(EventUser eventUser);

    /**
     * 删除事件与用户关联的表格信息
     * @param eventUser
     * @return
     */
    int deleteEventUser(EventUser eventUser);
    
    /**
     * 把用户添加组织机构时，添加事件与人员的关系
     * @param userList
     * @return
     */
    ResultExecution<EventUser> addEventUserByUserList(List<User> userList);
    
    /**
     * 把用户移除组织机构时，事件与人员的关系删除
     * @param userList
     * @return
     */
    ResultExecution<EventUser> removeEventUserByUserList(List<User> userList);

    
    /**
     * 修改事件与用户的相关状态
     * @param eventUser
     * @return
     */
    int updateEventUserById (EventUser eventUser);
    
    



}
