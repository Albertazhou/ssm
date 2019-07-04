package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.Civics;

public class CivicsServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private CivicsService civicsService;
	
	@Test
	public void selectByIdcard() {
		Civics civics = civicsService.selectByIdcard("440982199401014245");
		assertEquals("小鸿", civics.getName().toString().trim());
	}
}
