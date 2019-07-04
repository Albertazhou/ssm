package com.cetc.weiwen.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.cetc.weiwen.WeiwenServerApplicationTest;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.entity.User;

public class redisUtilsTest extends WeiwenServerApplicationTest {

	
	
	@Test
	public void testRedisSetAndGet() {
		User user1=new User();
		user1.setPhone("123456");
		user1.setCreateTime(new Date());
		RedisUtils.set("user_id", user1);
		User user2=RedisUtils.get("user_id", User.class);
		assertEquals(user2.getPhone(), user1.getPhone());
	}
	
	@Test
	public void testRedisDel() {
		boolean flag=RedisUtils.del("user_id");
		assertEquals(flag, true);
	}
	
	@Test
	public void testTime() {
		User user1=new User();
		user1.setPhone("123456");
		RedisUtils.set("user_id", user1,100);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long time=RedisUtils.getTtl("user_id");
		if(time>0L&&time<100L) {
			assertEquals(true, true);
			return ;
		}
		assertEquals(false, true);
	}
	
	@Test
	public void testOutTime() {
		User user1=new User();
		user1.setPhone("123456");
		RedisUtils.set("user_id", user1,1000L);
		//设置过期时间
		RedisUtils.expire("user_id", 100L);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long time=RedisUtils.getTtl("user_id");
		if(time>90L&&time<100L) {
			assertEquals(true, true);
			return ;
		}
		assertEquals(false, true);
	}
}
