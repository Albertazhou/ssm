package com.cetc.weiwen.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.Organization;

@Mapper
public interface OrganizationMapper {
 

    int deleteByPrimaryKey(Integer id);

    int insert(Organization record);

    int insertSelective(Organization record);


    Organization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    // 版本id大于orgVId的所有organization
    List<Organization> findByVidGreaThan(Integer orgVId);
    
    //根据uuid查找组织
    Organization findOrganizationByUuid(String orgUuid);
    
  //获取组织树列表展示
  	List<Organization> getOrganizationList();
  	
  	/**
  	 * 根据组织机构查询组织机构列表
  	 * @param org
  	 * @return
  	 */
	List<Organization> queryOrgListByOrg(Organization org);
}