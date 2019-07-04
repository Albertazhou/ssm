package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import com.cetc.weiwen.entity.EventProcess;

/**
 * 事件流程
 * @author jhl
 * @date 2018年9月10日 上午10:47:40
 * @version 1.0 
 *
 */
public interface EventProcessService {

	/**
	 * 获取事件流程具体信息
	 * @param eventProcess
	 * @return
	 */
	EventProcess queryEventProcess(EventProcess eventProcess);

	/**
	 * 获取详细流程图
	 * @param eventProcess
	 * @return
	 */
	List<Map<String, Object>> getEventProcessList(EventProcess eventProcess);
}
