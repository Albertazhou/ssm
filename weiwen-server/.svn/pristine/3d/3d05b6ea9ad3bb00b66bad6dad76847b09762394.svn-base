package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.service.EventTypeFunctionTypeService;

public class EventTypeFunctionTypeServiceTest extends WeiwenServerApplicationTest{

	@Autowired
	private EventTypeFunctionTypeService eventFunTypeService;
	
	@Test
	public void test() {
		List<Map<String,Object>> mapList = eventFunTypeService.getFuntionByEventType(
				"440304011000", 49);
		for (Map<String, Object> map : mapList) {
			System.out.println(map.get("name"));
		}
	}
}
