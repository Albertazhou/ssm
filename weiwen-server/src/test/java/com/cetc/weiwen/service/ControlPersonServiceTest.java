package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.ControlPerson;

public class ControlPersonServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private ControlPersonService controlPersonService;
	
	@Test
	@Ignore
	public void queryCivicsDetail() {
		Map<String,Object> map = controlPersonService.queryCivicsDetail(3);
		assertEquals("440982199401014245",map.get("idcard").toString().trim());
	}
	@Test
	public void createControlPerson() {
		ControlPerson cp=new ControlPerson();
		cp.setContradictionCategory(1);
		cp.setCreateTime(new Date());
		cp.setGrade(1);
		cp.setIdcard("432826199907283034");
		cp.setLastEditTime(new Date());
		cp.setPedigree(1);
		cp.setPersonLevel(1);
		cp.setProperty(1);
		cp.setRemark("无");
		cp.setSource(1);
		cp.setStatus(1);
		cp.setUserId(1);
		System.out.println(JSON.toJSONString(cp));
	}
}
