package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cetc.weiwen.WeiwenServerApplicationTest;

public class MediaServiceTest extends WeiwenServerApplicationTest {

	@Autowired
	private MediaService  mediaService;
	
	@Test
	//删除多媒体数据
	public void deleteMedia() {
		int code=mediaService.deleteMedia(38);
		assertEquals(1, code);
	}
}
