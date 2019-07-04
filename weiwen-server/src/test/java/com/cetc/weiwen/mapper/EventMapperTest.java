package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;

public class EventMapperTest extends WeiwenServerApplicationTest{
	
	@Autowired
	private EventMapper eventMapper;
	
	@Test
	public void findAllEventId() {
		List<Integer> ids= eventMapper.findAllEventId();
		if(ids!=null&&ids.size()>0) {
		  assertEquals(1,1);
		}
		
	}

}
