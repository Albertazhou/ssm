package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.vo.EventOrganizationVo;
import com.cetc.weiwen.vo.EventReceive;

public class EventServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private EventService eventService;
	
	@Test
	public void testEventCheckInfo() {
		Map<String,Object> map = eventService.getEventDetailInfo(1);
		List<EventOrganizationVo> eventOrgVoList = (List)map.get("eventOrg"); 
		assertEquals(3, eventOrgVoList.size());
		
	}
	
	@Test
	//新建事件
	public void createEvent() {
		EventReceive eventReceive=new EventReceive();
		Event event=new Event();
		List<EventOrganization> eventOrgList=new ArrayList<EventOrganization>();
		List<Integer> mediaList=new ArrayList<Integer>();
		List<EventCompany> eventCompanyList=new ArrayList<EventCompany>();
		User user=new User();
		user.setId(1);
		event.setChatTotal(0);
		event.setCreateTime(new Date());
		event.setDate(new Date());
		event.setLastEditTime(new Date());
		event.setLatitude(300.00);
		event.setLevelId(1);
		event.setLongitude(100.00);
		event.setMainAppeal("不服,来战");
		event.setMoneyInvolved(300.00);
		event.setMoneyUnit("华为大厂");
		event.setName("大厂欠钱");
		event.setNewChat("");
		event.setNumId(1);
		event.setOutline("要搞工农革命乎!");
		event.setPhase(1);
		event.setPlace("龙岗大道二号街");
		event.setRemark("暂无");
		event.setStatus(0);
		event.setTooksSteps("无");
		event.setTypeId(1);
		event.setVersion(0);
		
		EventCompany e=new EventCompany();
		e.setAddress("龙岗大道厚街");
		e.setAttention("高");
		e.setAttentionRank(1);
		e.setCompanyType(0);
		e.setCreateTime(new Date());
		e.setCreditCode("91440300MA5ELNE993");
		e.setEmployeeNum(100000);
		e.setLastEditTime(new Date());
		e.setLegalIdcard("513029198510100045");
		e.setLegalPerson("小黑");
		e.setLegalPhone("13575761957");
		e.setName("华为大厂");
		e.setRemark("做手机的大厂");
		e.setTopManagerName("陈玲");
		e.setTopManagerPhone("13875761957");
		eventCompanyList.add(e);
		
		mediaList.add(1);
		mediaList.add(2);
		EventOrganization eo=new EventOrganization();
		eo.setOrgId(105);
		eo.setType(0);
		eventOrgList.add(eo);
		eventReceive.setEvent(event);
		eventReceive.setAddEventCompanyIds(eventCompanyList);
		eventReceive.setAddEventOrgList(eventOrgList);
		eventReceive.setAddMediaIds(mediaList);
		int code = eventService.createEvent(eventReceive, user);
		System.out.println(JSON.toJSONString(eventReceive));
		assertEquals(1, code);
	}
	
	@Test
	public void updateEvent() {
		EventReceive eventReceive=new EventReceive();
		Event event=new Event();
		List<EventOrganization> eventOrgList=new ArrayList<EventOrganization>();
		List<Integer> mediaList=new ArrayList<Integer>();
		List<EventCompany> eventCompanyList=new ArrayList<EventCompany>();
		User user=new User();
		user.setId(1);
		event.setId(1);
		event.setChatTotal(0);
		event.setCreateTime(new Date());
		event.setDate(new Date());
		event.setLastEditTime(new Date());
		event.setLatitude(300.00);
		event.setLevelId(1);
		event.setLongitude(100.00);
		event.setMainAppeal("不服,来战");
		event.setMoneyInvolved(300.00);
		event.setMoneyUnit("华为大厂");
		event.setName("大厂欠钱");
		event.setNewChat("");
		event.setNumId(1);
		event.setOutline("要搞工农革命乎!");
		event.setPhase(1);
		event.setPlace("龙岗大道二号街");
		event.setRemark("暂无");
		event.setStatus(0);
		event.setTooksSteps("无");
		event.setTypeId(1);
		event.setVersion(0);
		
		EventCompany e=new EventCompany();
		e.setEventId(1);
		e.setCompanyId(1);
		e.setAddress("高新区");
		e.setAttention("高");
		e.setAttentionRank(1);
		e.setCompanyType(0);
		e.setCreateTime(new Date());
		e.setCreditCode("91440300MA5ELNE993");
		e.setEmployeeNum(100000);
		e.setLastEditTime(new Date());
		e.setLegalIdcard("513029198510100045");
		e.setLegalPerson("小黑");
		e.setLegalPhone("13575761957");
		e.setName("华为大厂");
		e.setRemark("做手机的大厂");
		e.setTopManagerName("陈玲");
		e.setTopManagerPhone("13875761957");
		eventCompanyList.add(e);
		
		mediaList.add(1);
		mediaList.add(2);
		EventOrganization eo=new EventOrganization();
		eo.setOrgId(1);
		eventOrgList.add(eo);
		eventReceive.setEvent(event);
		//1.添加涉事公司
		//eventReceive.setAddEventCompanyIds(eventCompanyList);
		//List<Integer> ids=new ArrayList<>();
		//ids.add(1);
		//3.删除涉事公司
		//eventReceive.setDelEventCompanyIds(ids);//公司ID
		//2.修改涉事公司
		//eventReceive.setEditEventCompanyIds(eventCompanyList);
		//1.添加组织架构
		//eventReceive.setAddEventOrgList(eventOrgList);
		//2删除组织架构
		List<Integer> evOrgIds=new ArrayList<Integer>();
		eventReceive.setDelEventOrgIds(evOrgIds);
		//1添加多媒体图片
		//eventReceive.setAddMediaIds(mediaList);
		//2删除多媒体图片
		//eventReceive.setDelMediaIds(mediaList);
		int code = eventService.updateEvent(eventReceive, user);
		assertEquals(1, code);
	}
	
	@Test
	public void getEvntDetail() {
		Map<String, Object> map = eventService.getEventDetailInfo(45);
		List<EventOrganizationVo> eventOrgVoList = (List)map.get("eventOrgList");
		System.out.println(JSON.toJSONString(map));
		assertEquals(3, eventOrgVoList.size());
	}
	
}
