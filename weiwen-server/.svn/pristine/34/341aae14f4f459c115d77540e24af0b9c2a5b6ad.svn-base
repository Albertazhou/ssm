package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.VisitRecord;

public class VisitRecordServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private VisitRecordService visitRecordService;
	
	@Test
	public void getVisitRecordList() {
		List<VisitRecord> visitRecordList = visitRecordService.getVisitRecordList("440982199401014245");
		assertEquals(1, visitRecordList.size());
	}
}
