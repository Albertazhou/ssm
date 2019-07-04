package com.cetc.weiwen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.DictionaryDelete;
import com.cetc.weiwen.entity.DictionaryEvent;
import com.cetc.weiwen.entity.DictionaryEventtype;
import com.cetc.weiwen.entity.Division;
import com.cetc.weiwen.entity.EventLevelContact;
import com.cetc.weiwen.entity.EventTypeFunctionType;
import com.cetc.weiwen.entity.FunctionType;
import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.entity.Position;
import com.cetc.weiwen.mapper.DictionaryDeleteMapper;
import com.cetc.weiwen.mapper.DictionaryEventMapper;
import com.cetc.weiwen.mapper.DictionaryEventtypeMapper;
import com.cetc.weiwen.mapper.DivisionMapper;
import com.cetc.weiwen.mapper.EventLevelContactMapper;
import com.cetc.weiwen.mapper.EventTypeFunctionTypeMapper;
import com.cetc.weiwen.mapper.FunctionTypeMapper;
import com.cetc.weiwen.mapper.OrganizationMapper;
import com.cetc.weiwen.mapper.PositionMapper;
import com.cetc.weiwen.service.SyncService;
import com.cetc.weiwen.vo.SynDictionaryVo;

@Service
public class SyncServiceImpl implements SyncService {

	@Autowired
	private DictionaryDeleteMapper dictionaryDeleteMapper;
	
	@Autowired
	private DictionaryEventMapper dictionaryEventMapper;
	
	@Autowired
	private DictionaryEventtypeMapper dictionaryEventtypeMapper;
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@Autowired
	private EventLevelContactMapper eventLevelContactMapper;
	
	@Autowired FunctionTypeMapper functionTypeMapper;
	
	@Autowired DivisionMapper divisionMapper;
	
	@Autowired EventTypeFunctionTypeMapper eventTypeFunctionTypeMapper;
	
	@Autowired PositionMapper positionMapper;

	@Override
	public SynDictionaryVo sync(Integer delVId, Integer eventVId, Integer eventTypeVId, Integer orgVId,
			Integer eventLevelContactVId, Integer functionTypeVId, Integer divisionVId,
			Integer eventTypeFunctionTypeVId, Integer positionVId) {
		 //同步处理逻辑
		/*同步删除表*/
		List<DictionaryDelete> dD=dictionaryDeleteMapper.findByVidGreaThan(delVId);
		/*事件相关的字典数据*/
		List<DictionaryEvent> dE=dictionaryEventMapper.findByVidGreaThan(eventVId);
		/*事件类型字典数据*/
		List<DictionaryEventtype> dDT=dictionaryEventtypeMapper.findByVidGreaThan(eventTypeVId);
		/*组织架构*/
		List<Organization> orgs=organizationMapper.findByVidGreaThan(orgVId);
		/*事件级别对照*/
		List<EventLevelContact> eventLevelContacts=eventLevelContactMapper.findByVidGreaThan(eventLevelContactVId);
		/*职能部门类型*/
		List<FunctionType> functionTypes=functionTypeMapper.findByVidGreaThan(functionTypeVId);
		/*行政区划*/
		List<Division> divisions=divisionMapper.findByVidGreaThan(divisionVId);
		/*事件类型与职能部门类型的关联表*/
		List<EventTypeFunctionType> eventTypeFunctionTypes=eventTypeFunctionTypeMapper.findByVidGreaThan(eventTypeFunctionTypeVId);
		/*岗位表*/
		List<Position> positions=positionMapper.findByVidGreaThan(positionVId);
		
		SynDictionaryVo syncDV=new SynDictionaryVo();
		syncDV.setDicDels(dD);
		syncDV.setDicEvents(dE);
		syncDV.setDicEventTypes(dDT);
		syncDV.setOrgs(orgs);
		syncDV.setDivisions(divisions);
		syncDV.setEventLevelContacts(eventLevelContacts);
		syncDV.setEventTypeFunctionTypes(eventTypeFunctionTypes);
		syncDV.setFunctionTypes(functionTypes);
		syncDV.setPositions(positions);
		
		
		return syncDV;
	}
	
	
	

}
