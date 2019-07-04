package com.cetc.weiwen.mapper;

import java.util.List;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.vo.UserVo;

@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 获取用户列表，返回map
     * @param user
     * @return
     */
    List<HashMap<String,Object>> getUserList(User user);

	List<UserVo> queryUserByName(@Param("name")String name);

	int countUser();

	List<UserVo> queryUserByOrgId(Integer orgId);

	UserVo queryUserById(Integer id);

	/**
	 * 根据用户名查询用户
	 * @param name
	 * @return
	 */
	User findByUserName(@Param("name")String name);

	int updateByIdAndStatus(Integer id);
	
	/*账号就是手机号码,根据phone查找用户*/
	User queryUserByPhone(String phone);
	/*根据组织架构id获取用户*/
	List<User> getUserListByOrgId(Integer orgId);
	/*根据事件id查找用户信息*/
	List<User> findUserListByEventId(@Param("eventId")Integer eventId);
	
}