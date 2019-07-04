package com.cetc.weiwen.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.EventOrganization;

public class EventOrgMapperTest extends WeiwenServerApplicationTest{
	
	@Autowired
	private EventOrganizationMapper eventOrgMapper;
	
	@Test
	public void batchInsertEventOrg() {
		List<EventOrganization> eventOrgList=new ArrayList<EventOrganization>();
		EventOrganization eo1=new EventOrganization();
		eo1.setEventId(55);
		eo1.setOrgId(55);
		EventOrganization eo2=new EventOrganization();
		eo2.setEventId(55);
		eo2.setOrgId(66);
		EventOrganization eo3=new EventOrganization();
		eo3.setEventId(55);
		eo3.setOrgId(77);
		eventOrgList.add(eo1);
		eventOrgList.add(eo2);
		eventOrgList.add(eo3);
		eventOrgMapper.batchInsertEventOrg(eventOrgList);
	}
	
	//
	@Test
	public void batchDeleteEventCompany() {
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(55);
		ids.add(66);
		ids.add(77);
		eventOrgMapper.batchDeleteEventOrg(55,ids);
	}
	
	
}
