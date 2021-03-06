package com.cetc.weiwen.service;

import java.util.HashMap;
import java.util.List;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface UserService {

	/**
	 * 
	 * @param id
	 * @return
	 */
    int deleteById(Integer id);

    /**
     * 插入用户
     * @param record
     * @return
     */
    int insertUser(User user);

    /**
     * 插入用户，存在判断语句
     * @param user
     * @return
     */
    int insertPartUser(User user);


    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    UserVo queryUserById(Integer id);

    /**
     * 根据用户id进行更新，存在判断语句(推荐)
     * @param record
     * @return
     */
    int updateByUserId(User user);

    /**
     * 根据id进行更新，不存在判断
     * @param user
     * @return
     */
    int updateById(User user);
    
    /**审核事件
     * 更新事件状态
     * @param event
     * @return
     */
    int updataEventToExamine(Integer id,Integer eventId,Event event);


	/**删除事件--->逻辑删除(更新事件状态)
   	 * @return
   	 */
	int deleteUserEvent(Integer id, Integer eventId);
	
	/**
     * 获取用户列表，返回map
     * @param user
     * @return
     */
    List<HashMap<String,Object>> getUserList(User user);
   

	PageInfo<UserVo> getUserList(Integer pageNum, Integer pageSize, String name,Integer orgId);

	User queryUserByPhone(String phone);

	User login(User user, String userPrefix, String userTokenPrefix);

	int logout(String token1, String token2,Integer id,String userPrefix,String userTokenPrefix );
	
	//获取用户需要审核的事件
	List<Event> findUnReviewedEvent(Integer userId);

}
