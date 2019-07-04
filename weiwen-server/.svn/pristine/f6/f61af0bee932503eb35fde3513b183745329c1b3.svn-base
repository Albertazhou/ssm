package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.DictionaryEvent;

public class DictionaryEventMapperTest extends WeiwenServerApplicationTest {
	
	@Autowired
	private DictionaryEventMapper dictionaryEventMapper;
	
	@Test
	public void queryDictionaryEvent() {
		
		List<DictionaryEvent> list=new ArrayList<DictionaryEvent>();
		
		list=dictionaryEventMapper.findByVidGreaThan(0);
		
			assertTrue(list.size()<0);
			
			System.out.println(list.size());
		
	}

}
