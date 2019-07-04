package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.Media;

public class MediaMapperTest extends WeiwenServerApplicationTest{

	@Autowired
	private MediaMapper  mediaMapper;
	
	@Test
	public void update() {
		List<Integer> ids=new ArrayList<Integer>();
	    ids.add(2);
	    ids.add(3);
	    ids.add(4);
		mediaMapper.updateGeneralIdAndFunTypeById(1,0,ids);
		Media media=mediaMapper.selectByPrimaryKey(2);
		Integer funtype=0;
		assertEquals(funtype, media.getFunType());
	}

}
