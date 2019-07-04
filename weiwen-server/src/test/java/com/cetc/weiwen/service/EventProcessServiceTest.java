package com.cetc.weiwen.service;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.EventProcess;

public class EventProcessServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private EventProcessService eventProcessService;
	
	@Test
	@Ignore
	public void queryEventProcess() {
		EventProcess eventProcess = new EventProcess();
		eventProcess.setEventId(1);
		EventProcess e = eventProcessService.queryEventProcess(eventProcess);
		System.out.println("=====================================");
		System.out.println(e.getEventId());
		System.out.println("=====================================");
	}
	
	@Test
	public void getEventProcessList() {
		EventProcess eventProcess = new EventProcess();
		eventProcess.setEventId(1);
		List<Map<String, Object>> mapList = eventProcessService.getEventProcessList(eventProcess);
		for (Map<String, Object> map : mapList) {
			System.out.println("=====================================");
			System.out.println(map.get("time"));
			System.out.println("=====================================");
		}
	}
}
