package com.cetc.weiwen.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.EventCompany;

public class EventCompanyMapperTest extends WeiwenServerApplicationTest{

	@Autowired
	private EventCompanyMapper eventCompanyMapper;
	
	@Test
	public void batchUpdateEventCompanyTest() {
		List<EventCompany> eventCompanyList=new ArrayList<EventCompany>();
		EventCompany eventCompany1=new EventCompany();
		eventCompany1.setCompanyId(11);
		eventCompany1.setEventId(45);
		eventCompany1.setAddress("南山");
		EventCompany eventCompany2=new EventCompany();
		eventCompany2.setCompanyId(10);
		eventCompany2.setEventId(44);
		eventCompany2.setAddress("南山");
		eventCompanyList.add(eventCompany1);
		eventCompanyList.add(eventCompany2);
		eventCompanyMapper.batchUpdateEventCompany(eventCompanyList);
	}
	
	@Test
	public void batchDeleteEventCompany() {
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(11);
		ids.add(10);
		eventCompanyMapper.batchDeleteEventCompany(43,ids);
	}
}
