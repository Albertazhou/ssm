package com.cetc.weiwen.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cetc.weiwen.vo.EventVo;

/**首页展示测试用例
 * 
 * @author liqiaofei
 * 2018年9月20日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventOrderTest {
	@Autowired
	private EventService eventService;

	@Test
	public void getEventListOrder() {
		//0表示按时间排序，1表示按级别排序，2表示按事件类型排序(首页展示)
		List<EventVo> list=eventService.getEventListOrder(0, 1);
		if(list.size()>1) {
			EventVo v=list.get(0);
			System.out.println(v.getId()+":"+v.getNewChat());
			assertEquals(1, 1);
		}else {
			assertEquals(1, 0);
		}
	}
	
	@Test
	public void getEvent() {
		//0表示按时间排序，1表示按级别排序，2表示按事件类型排序(首页展示)
		Integer code=eventService.setEventTop(1, 1L, 1);
		if(code>0) {
			System.out.println(code);
			assertEquals(1, 1);
		}else {
			assertEquals(1, 0);
		}
	}
}
