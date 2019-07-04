package com.cetc.weiwen.service;

import java.util.List;

import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.vo.EventOrganizationVo;

public interface EventOrganizationService {

	/**
	 * 插入信息
	 * @param eventOrganization
	 * @return
	 */
	int insertMediaOrg(EventOrganization eventOrganization);
	
	/**
	 * 批量添加信息
	 * @param eventOrgList
	 * @return
	 */
	int batchInsertEventOrg(List<EventOrganization> eventOrgList, Integer eventId);
	
	/**
	 * 根据id获取信息列表
	 * @param eventId
	 * @return
	 */
	List<EventOrganizationVo> queryEventOrgVoList(Integer eventId);

	/**
	 * 添加事件的涉事公司
	 * @param eventOrg
	 * @return
	 */
	int insertEventOrg(EventOrganization eventOrg);

	/**
	 * 删除组织机构
	 * @param eventOrg
	 * @return
	 */
	int deleteEventOrg(EventOrganization eventOrg);
}
