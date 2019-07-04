package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import com.cetc.weiwen.entity.ControlPerson;

public interface ControlPersonService {

	/**
	 * 获取重点人信息表
	 * @param status 
	 * @param controlPerson
	 * @return
	 
	List<Map<String,Object>> queryControlPersonList(String regionalName,
			String townName,String civicsName, Integer status);
			*/

	/**
	 * 删除重点人
	 * @param id
	 * @return
	 */
	int deleteControlPerson(Integer id);
	
	/**
     * 获取公民的详细信息
     * @param idcard
     * @return
     */
	Map<String,Object> queryCivicsDetail(Integer id);

    /**
     * 插入重点人信息
     * @param controlPerson
     * @return
     */
	int insertControlPerson(ControlPerson controlPerson);

	/**
	 * 更新重点人信息
	 * @param controlPerson
	 * @return
	 */
	int updateControlPerson(ControlPerson controlPerson);
}
