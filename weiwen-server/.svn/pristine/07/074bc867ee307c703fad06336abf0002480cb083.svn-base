package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.entity.Event;

public class UserServiceTest extends WeiwenServerApplicationTest{
	@Autowired
	private UserService userService;
	
	@Test
	public void testGetEventUnReviewed() {
		List<Event> lists=userService.findUnReviewedEvent(34);
		
		assertEquals(3, lists.size());
		
	}
	

}
