package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.Civics;

public class CivicsMapperTest extends WeiwenServerApplicationTest {

	@Autowired
	private CivicsMapper civicsMapper;
	
	@Test
	public void selectByIdcard() {
		List<String> list=new ArrayList<String>();
		list.add("440982155554441558");
		list.add("440982199401014244");
		List<Civics> civics = civicsMapper.getCivicsList(list);
		assertEquals(civics.size(), 2);
	}
}
