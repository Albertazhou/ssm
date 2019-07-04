package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.SmsInfo;

public class SmsInfoMapperTest extends WeiwenServerApplicationTest {

	@Autowired
	private SmsInfoMapper smsInfoMapper;
	
	@Test
	public void selectByIdcard() {
		List<SmsInfo> list=new ArrayList<SmsInfo>();
		SmsInfo smsInfo1=new SmsInfo();
		SmsInfo smsInfo2=new SmsInfo();
		smsInfo1.setCivicsIdcard("440982155554441512");
		smsInfo1.setContent(1);
		smsInfo1.setCreateTime(new Date());
		smsInfo1.setEventId(1);
		smsInfo1.setTaskId(1);
		smsInfo1.setUserId(1);
		smsInfo2.setCivicsIdcard("440989055554441558");
		smsInfo2.setContent(1);
		smsInfo2.setCreateTime(new Date());
		smsInfo2.setEventId(1);
		smsInfo2.setTaskId(1);
		smsInfo2.setUserId(1);
		list.add(smsInfo1);
		list.add(smsInfo2);
		int code= smsInfoMapper.batchSmsInfo(list);
		assertEquals(code, 2);
	}
}
