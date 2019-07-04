package com.cetc.weiwen.service;

import java.util.List;

import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.vo.EventCompanyVo;

public interface EventCompanyService {

	/**
	 * 插入信息
	 * @param record
	 * @return
	 */
    int insertEventCompany(EventCompany eventCompany);

    /**
     * 插入信息，存在判断语句
     * @param record
     * @return
     */
    int insertPartEventCompany(EventCompany eventCompany);
    
    /**
     * 根据EventCompany获取信息列表
     * @param eventCompany
     * @return
     */
    List<EventCompanyVo> queryEventComVoList(EventCompany eventCompany);
    
    /**
     * 批量添加信息
     * @param eventCompanyList
     * @return
     */
    int batchInsertEventCom(List<EventCompany> eventCompanyList,int eventId);
    
    /**
     * 获取事件与公司的列表信息
     * @param eventCompany
     * @return
     */
    List<EventCompany> getEventCompanyList(EventCompany eventCompany);

    /**
     * 删除公司与事件的关系表信息
     * @param id
     * @return
     */
	int deleteEventCompany(EventCompany eventCompany);
}
