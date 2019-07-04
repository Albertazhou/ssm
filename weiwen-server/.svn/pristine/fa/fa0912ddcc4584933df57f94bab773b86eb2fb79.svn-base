package com.cetc.weiwen.service;

import java.util.List;

import org.springframework.cache.annotation.CachePut;

import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.entity.Position;
import com.cetc.weiwen.vo.OrganizationDivisionVo;

/**
 * 
 * @author zhou
 * @Modify 2018/8/6
 *
 */
public interface OrganizationService {
	
	/**
	 * 获取组织机构列表展示
	 * @return
	 */
	List<Organization> getOrganizationList();
	
	/**
	 * 获取组织机构(包括行政信心)列表展示
	 * @return
	 
	List<OrganizationDivisionVo> getOrganizationDivisionList();
	*/
	
	/**
	 * 新增一个组织
	 * @return
	
	
	Organization insertOrganization(Organization organization);
	 */
	
	
	
	/**
	 * 修改组织
	 * @param organization
	 * @return
	 
	int updateOrganizationByUuid(Organization organization);
	*/
	
	/**
	 * 删除一个组织
	 */
	//int updateValid(Organization organization);
	
	/**根据事件类型id查询相关的组织架构
	 * 
	 * @param id
	 * @param divisionId
	 * @return
	
	List<Organization> findOrganizationByEventTypeIdAndDivisionId(Integer id, Integer divisionId);
	 */
	/**
	 * 根据指定的组织查找下面所有组织
	 * @param organization
	 * @return
	 */
	//List<OrganizationDivisionVo> getOrgByPath(Organization organization); 
	
	/**
	 * 查找特定组织的所有职位
	 * @param orgId
	 * @return
	 
	List<Position> findPositionByOrgUuid(String orgUuid);
	*/
	/**
	 * 根据组织uuid查找组织是否存在
	 * @param orgUuid
	 * @return
	
	boolean isExit(String orgUuid);
	 */
	
	/**
	 * 根据uuid删除组织
	 * @param orgUuid
	 * @return
	
	int deleteByUuid(String orgUuid);
	 */
	 //根据uuid查找组织
    Organization findOrganizationByUuid(String orgUuid);
	
	

}
