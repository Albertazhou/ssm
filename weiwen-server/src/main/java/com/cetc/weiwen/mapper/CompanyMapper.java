package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Company;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    /**
     * 根据id获取公司信息
     * @param id
     * @return
     */
    Company getCompanyById(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    /*根据企业统一社会编码查询公司信息*/
	Company getCompanyByCreditCode(String creditCode);
}