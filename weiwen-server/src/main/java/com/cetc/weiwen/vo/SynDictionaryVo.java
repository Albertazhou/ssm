package com.cetc.weiwen.vo;

import java.util.List;

import com.cetc.weiwen.entity.DictionaryDelete;
import com.cetc.weiwen.entity.DictionaryEvent;
import com.cetc.weiwen.entity.DictionaryEventtype;
import com.cetc.weiwen.entity.Division;
import com.cetc.weiwen.entity.EventLevelContact;
import com.cetc.weiwen.entity.EventTypeFunctionType;
import com.cetc.weiwen.entity.FunctionType;
import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.entity.Position;

/**
 * app字典数据同步视图
 * 
 * @author liqiaofei 2018年9月10日
 */
public class SynDictionaryVo {
	/*同步删除表信息*/
	private List<DictionaryDelete> dicDels;
	
	/*同步事件通用字典表*/
	private List<DictionaryEvent> dicEvents;
	
	/*同步事件类型*/
	private List<DictionaryEventtype> dicEventTypes;

	/*同步组织架构*/
	private List<Organization> Orgs;
	
	//同步事件級別人數關聯表
	private List<EventLevelContact> eventLevelContacts;
	
	//同步職能部門類型表
	private List<FunctionType> functionTypes;
	
	//同步行政区划表
	private List<Division> divisions;
	
	//事件类型与职能部门关联表
	private List<EventTypeFunctionType> eventTypeFunctionTypes;
	
	//岗位表
	private List<Position> positions;

	public List<EventLevelContact> getEventLevelContacts() {
		return eventLevelContacts;
	}

	public void setEventLevelContacts(List<EventLevelContact> eventLevelContacts) {
		this.eventLevelContacts = eventLevelContacts;
	}

	public List<FunctionType> getFunctionTypes() {
		return functionTypes;
	}

	public void setFunctionTypes(List<FunctionType> functionTypes) {
		this.functionTypes = functionTypes;
	}

	public List<Division> getDivisions() {
		return divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public List<EventTypeFunctionType> getEventTypeFunctionTypes() {
		return eventTypeFunctionTypes;
	}

	public void setEventTypeFunctionTypes(List<EventTypeFunctionType> eventTypeFunctionTypes) {
		this.eventTypeFunctionTypes = eventTypeFunctionTypes;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public List<DictionaryDelete> getDicDels() {
		return dicDels;
	}

	public void setDicDels(List<DictionaryDelete> dicDels) {
		this.dicDels = dicDels;
	}

	public List<DictionaryEvent> getDicEvents() {
		return dicEvents;
	}

	public void setDicEvents(List<DictionaryEvent> dicEvents) {
		this.dicEvents = dicEvents;
	}

	public List<DictionaryEventtype> getDicEventTypes() {
		return dicEventTypes;
	}

	public void setDicEventTypes(List<DictionaryEventtype> dicEventTypes) {
		this.dicEventTypes = dicEventTypes;
	}

	public List<Organization> getOrgs() {
		return Orgs;
	}

	public void setOrgs(List<Organization> orgs) {
		Orgs = orgs;
	}

}
