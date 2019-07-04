package com.cetc.weiwen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.DictionaryDelete;
import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.entity.Position;
import com.cetc.weiwen.mapper.DictionaryDeleteMapper;
import com.cetc.weiwen.mapper.OrganizationMapper;
import com.cetc.weiwen.mapper.PositionMapper;
import com.cetc.weiwen.service.OrganizationService;
import com.cetc.weiwen.vo.OrganizationDivisionVo;

/**
 * @author zhou
 *
 */
/**
 * @author zhou
 *
 */
@Service
@CacheConfig(cacheNames="orgCache") // 本类内方法指定使用缓存时，默认的名称就是userCache
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Autowired
	private PositionMapper positionMapper;
	
	@Autowired
	private DictionaryDeleteMapper dictionaryDeleteMapper;
	
	
	/* (non-Javadoc)
	 * 获取组织列表
	 * @see com.cetc.weiwen.service.OrganizationService#getOrganizationList()
	 */
	@Override
	public List<Organization> getOrganizationList() {
		// TODO Auto-generated method stub
		return organizationMapper.getOrganizationList();
	}


	/* (non-Javadoc)
	 * 新增一个组织
	 * @see com.cetc.weiwen.service.OrganizationService#insertOrganization()
	 
	@Override
	@CachePut(key="#organization.name")  //#p0表示第一个参数
	public Organization insertOrganization(Organization organization) {
		// TODO Auto-generated method stub
		organization.setId(null);
		if(organization.getDivisionId() ==null
				||organization.getFunctionTypeId()==null
				||organization.getName()==null
				||organization.getParentId()==null) {
			return null;
		}
			
		if(organization.getParentId()==null) {
			organization.setParentId("0");//第一级组织的parentId为0
		}
			
		organizationMapper.insertOrganization(organization) ;
		
		Organization org1=organizationMapper.getLastOrganization();
		return org1;
	}
	*/

	
	/* (non-Javadoc)
	 * 修改组织
	 * @see com.cetc.weiwen.service.OrganizationService#updateOrganizationById(com.cetc.weiwen.entity.Organization)
	 
	@Override
	public int updateOrganizationByUuid(Organization organizationMore) {
		// TODO Auto-generated method stub
		
		//根据uuid查找组织数据
		Organization oldOrganization =organizationMapper.findOrganizationByUuid(organizationMore.getUuid());
		
		
		//将需要修改得数据赋进去
		if(organizationMore.getName()!=null&&organizationMore.getName()!="") {
			oldOrganization.setName(organizationMore.getName());
		}
		if(organizationMore.getParentId()!=null&&organizationMore.getParentId()!="") {
			oldOrganization.setParentId(organizationMore.getParentId());
		}
		if(organizationMore.getDivisionId()!=null) {
			oldOrganization.setDivisionId(organizationMore.getDivisionId());
		}
		if(organizationMore.getFunctionTypeId()!=null) {
			oldOrganization.setFunctionTypeId(organizationMore.getFunctionTypeId());
		}
		if(organizationMore.getType()!=null) {
			oldOrganization.setType(organizationMore.getType());
		}
		
		
		
		DictionaryDelete dictionaryDelete=new DictionaryDelete();
		dictionaryDelete.setTableName("organization");
		dictionaryDelete.setTableId(oldOrganization.getId());
		
		//将删除得组织记录到删除记录表里,
		if(dictionaryDeleteMapper.addDictionaryDelete(dictionaryDelete)>0
				&&organizationMapper.deleteByUuid(organizationMore.getUuid())>0
				&&organizationMapper.insertOrganizationByUuid(oldOrganization)>0) {
			return 1;
		}
		return 0;
	
	}
*/

	/* (non-Javadoc)
	 * 删除一个组织
	 * @see com.cetc.weiwen.service.OrganizationService#deleteOrganization(com.cetc.weiwen.entity.Organization)
	 
	@Override
	public int updateValid(Organization organization) {
		// TODO Auto-generated method stub
		int update1=organizationMapper.updateValid(organization);
		String newPath=organization.getPath()+"-"+organization.getId();
		organization.setPath(newPath);
		int update2=organizationMapper.updateNextValid(organization);
		if(update1==0) {
			return -1;
		}
		return 1;
		
	}
	*/

	
	/* (non-Javadoc)
	 * 获取组织列表
	 * @see com.cetc.weiwen.service.OrganizationService#getOrganizationDivisionList()
	 
	@Override
	
	public List<OrganizationDivisionVo> getOrganizationDivisionList() {
		// TODO Auto-generated method stub
		System.out.println(organizationMapper.getOrganizationDivisionList().size()+"----------------------");
		return organizationMapper.getOrganizationDivisionList();
	}
	*/
	
	/**根据事件类型id查询相关的组织架构
	 * 
	 * @param id
	 * @param divisionId
	 * @return
	 
	@Override
	public List<Organization> findOrganizationByEventTypeIdAndDivisionId(Integer id, Integer divisionId) {
		// TODO Auto-generated method stub
		return organizationMapper.findOrganizationByEventTypeIdAndDivisionId(id,divisionId);
	}
	*/


	/* (non-Javadoc)
	 * 根据指定的组织查找下面所有组织
	 * @see com.cetc.weiwen.service.OrganizationService#getOrgByPath(com.cetc.weiwen.entity.Organization)
	 
	@Override
	public List<OrganizationDivisionVo> getOrgByPath(Organization organization) {
		// TODO Auto-generated method stub
		String path=organization.getPath()+"-"+organization.getId();
		organization.setPath(path);
		return organizationMapper.getOrgByPath(organization);
	}
	*/

	
	
	/* 获取特定组织的所有职位
	 * @see com.cetc.weiwen.service.OrganizationService#findPositionByOrgid(java.lang.Integer)
	 
	@Override
	public List<Position> findPositionByOrgUuid(String orgUuid) { 
		// TODO Auto-generated method stub
		return positionMapper.findPositionByOrgid(orgUuid);
	}
	*/

	/**
	 * 根据组织uuid查找组织是否存在
	 
	@Override
	public boolean isExit(String orgUuid) {
		// TODO Auto-generated method stub
		if( organizationMapper.findOrganizationByUuid(orgUuid)!=null) {
			return true;
		}else {
			return false;
		}
		
	}
	*/


	/* (non-Javadoc)
	 * 根据uuid删除组织
	 * @see com.cetc.weiwen.service.OrganizationService#deleteByUuid(java.lang.String)
	 
	@Override
	public int deleteByUuid(String orgUuid) {
		// TODO Auto-generated method stub
		Organization organization =organizationMapper.findOrganizationByUuid(orgUuid);
		
		DictionaryDelete dictionaryDelete=new DictionaryDelete();
		dictionaryDelete.setTableName("organization");
		dictionaryDelete.setTableId(organization.getId());
		
		dictionaryDeleteMapper.addDictionaryDelete(dictionaryDelete);
		
		return organizationMapper.deleteByUuid(orgUuid);
	}
	*/


	@Override

	@Cacheable(key="#orgUuid")
	public Organization findOrganizationByUuid(String orgUuid) {
		// TODO Auto-generated method stub
		return organizationMapper.findOrganizationByUuid(orgUuid);
	} 

}
