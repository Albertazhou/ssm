package com.cetc.weiwen.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.EventProcess;

/**
 * 事件流程
 * @author jhl
 * @date 2018年9月10日 上午10:47:51
 * @version 1.0 
 *
 */
@Mapper
public interface EventProcessMapper {

	/**
	 * 获取事件流程具体信息
	 * @param eventProcess
	 * @return
	 */
	EventProcess queryEventProcess(EventProcess eventProcess);

	/**
	 * 插入事件流程信息
	 * @param eventProcess
	 * @return
	 */
	int insertEventProcess(EventProcess eventProcess);
	
	/**
	 * 根据事件id获取事件流程
	 * @param id
	 * @return
	 */
	EventProcess getEventProcessById(Integer id);
	
	/**
	 * 更新事件流程信息
	 * @param eventProcess
	 * @return
	 */
	int updateEventProcess(EventProcess eventProcess);
}
