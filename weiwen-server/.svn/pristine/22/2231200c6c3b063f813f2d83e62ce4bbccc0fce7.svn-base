package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.vo.SmsParam;

public class SmsServiceTest extends WeiwenServerApplicationTest{

	@Autowired
	private SmsService smsService;
	
	
	@Test
	public void sendSms() {
		SmsParam smsParam=new SmsParam();
		List<String> civicsList=new ArrayList<String>();
		civicsList.add("440982155554441558");
		civicsList.add("440982199401014244");
		civicsList.add("440982199401014244");
		smsParam.setCivicsList(civicsList);
		smsParam.setEventId(1);
		smsParam.setSmsType(1);
		smsParam.setTaskId(null);
		//发送短信
		int code=smsService.sendSms(smsParam, 1);
		if(code>1) {
			assertEquals(1,1);
		}else {
			assertEquals(1,0);
		}
		
	}
}
