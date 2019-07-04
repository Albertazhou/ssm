package com.cetc.weiwen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.EventCompany;

@Mapper
public interface EventCompanyMapper {

    int insert(EventCompany record);
    
    

    int insertSelective(EventCompany record);

    /**
     * 获取事件与公司的列表
     * @param eventCompany
     * @return
     */
	List<EventCompany> getEventCompanyList(EventCompany eventCompany);

	/**
	 * 批量添加事件与公司的关系列表
	 * @param eventCompanyList
	 * @return
	 */
	int batchInsertEventCompany(List<EventCompany> eventCompanyList);

	/**
	 * 删除公司与事件的关联信息
	 * @param id
	 * @return
	 */
	int deleteEventCompany(EventCompany eventCompany);



	int batchUpdateEventCompany(List<EventCompany> eventCompanyList);

    //获取这个事件对应的所用的公司
	List<EventCompany> findByEventId(Integer id);



	int batchDeleteEventCompany(@Param("eventId")Integer eventId,  @Param("list")List<Integer> ids);

}