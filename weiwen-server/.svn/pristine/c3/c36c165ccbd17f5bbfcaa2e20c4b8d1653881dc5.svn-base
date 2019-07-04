package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.EventChat;

public class ChatInfoServiceTest extends WeiwenServerApplicationTest {
	@Autowired
	private EventChatService chatInfoService;
	
	@Test
	public void sendChatInfo() {
		EventChat record=new EventChat();
		//record.setContent("hello time:"+System.currentTimeMillis());
		record.setCreateTime(new Date());
		record.setEventId(1);
		record.setUserId(1);
//		//int code= chatInfoService.sendChatInfo(record);
//		System.out.println(code);
//		if(code>47) {
//			assertEquals(1, 1);
//			return;
//		}
		assertEquals(1, 0);
	}
}
