package com.cetc.weiwen.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.EventUser;

public class EventUserMapperTest extends WeiwenServerApplicationTest{

	@Autowired
	private EventUserMapper eventUserMapper;
	
	@Test
	public void batchInsertEventUser() {
		List<EventUser> addEventUser=new ArrayList<EventUser>();
		EventUser eu1=new EventUser();
		eu1.setEventId(55);
		eu1.setUserId(66);
		EventUser eu2=new EventUser();
		eu2.setEventId(55);
		eu2.setUserId(77);
		EventUser eu3=new EventUser();
		eu3.setEventId(55);
		eu3.setUserId(77);
		addEventUser.add(eu1);
		addEventUser.add(eu2);
		addEventUser.add(eu3);
		eventUserMapper.batchInsertEventUser(addEventUser);
	}
	
	@Test
	public void batchDelteEventUser() {
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(66);
		ids.add(77);
		ids.add(88);
		eventUserMapper.batchDelteEventUser(55,ids);
	}
}
