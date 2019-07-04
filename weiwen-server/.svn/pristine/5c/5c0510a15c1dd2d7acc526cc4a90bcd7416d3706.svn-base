package com.cetc.weiwen.service;

import java.util.Map;

import com.cetc.weiwen.entity.Company;
import com.cetc.weiwen.entity.EventCompany;

public interface CompanyService {

	int save(EventCompany eventCompany);
	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
    int deleteById(Integer id);

    /**
     * 插入公司信息
     * @param company
     * @return
     */
    int insertCompany(Company company);

    /***
     * 插入公司信息，存在判断信息
     * @param record
     * @return
     */
    int insertPartCompany(Company company);

    
    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    Company queryCompanyById(Integer id);

    /**
     * 根据id进行更新操作
     * @param company
     * @return
     */
    int updateCompanyById(Company company);

    /**
     * 根据id进行部分更新，存在判断语句
     * @param record
     * @return
     */
    int updateCompanyPartById(Company company);
    
    /**根据事件id分页查询涉企业信息
	 * 
	 * @param id
	 * @param num
	 * @param size
	 * @return
	 */
	Map<String, Object> queryCompanyListByEventId(Integer id, Integer num, Integer size);

	/**
	 * 获取公司的详细信息
	 * @param companyId
	 * @return
	 */
	Map<String, Object> queryCompanyDetail(Integer companyId);
}
