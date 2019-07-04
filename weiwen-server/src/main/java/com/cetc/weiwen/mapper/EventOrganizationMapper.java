package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.vo.EventOrganizationVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventOrganizationMapper {

    int insert(EventOrganization record);

    int insertSelective(EventOrganization record);

    /**
     * 批量添加事件与组织机构的关系信息
     * @param eventOrgList
     * @return
     */
	int batchInsertEventOrg(List<EventOrganization> eventOrgList);

	/**
	 * 获取事件与组织机构的关系
	 * @param eventOrg
	 * @return
	 */
	List<EventOrganizationVo> getEventOrgVoList(EventOrganization eventOrg);
	
	//根据事件id查找对应的组织架构
	List<EventOrganization> findEventOrganizationByEventId(Integer id);
	
	//批量删除事件与组织机构的关系信息
	int batchDeleteEventOrg(Integer eventId,List<Integer> ids);

}