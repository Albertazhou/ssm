package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import com.cetc.weiwen.entity.EventTypeFunctionType;

/**
 * 事件类型与职能部门类型关联表业务层
 * @author jhl
 * @date 2018年8月29日 上午10:23:49
 * @version 1.0 
 *
 */
public interface EventTypeFunctionTypeService {

	/**
	 * 插入职能部门与事件类型的关联数据
	 * @param record
	 * @return
	 */
    int insertEventFunction(EventTypeFunctionType record);

    /**
     * 获取事件类型与职能部门类型的关联数据
     * @param eventFunction
     * @return
     */
    List<EventTypeFunctionType> queryEventTypeFunType(EventTypeFunctionType eventFunction);
    
    /**
     * 根据事件类型和行政区划获取
     * @param district
     * @param adcode
     * @param eventTypeId
     * @return
     */
    List<Map<String, Object>> getFuntionByEventType(String adcode,Integer eventTypeId);
}
