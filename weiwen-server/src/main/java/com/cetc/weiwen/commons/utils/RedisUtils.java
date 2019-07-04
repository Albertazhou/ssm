package com.cetc.weiwen.commons.utils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;

/**对springbot中的redis进行一个简单的封装
 * 
 * @author liqiaofei
 * 2018年9月28日
 */
public class RedisUtils {

    protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private static  StringRedisTemplate jedis; 
	
	static {
		jedis= SpringContextHolder.getBean(StringRedisTemplate.class);
	}
	
	public static String  get(String key) {
		return jedis.opsForValue().get(key);
	}
	
	
	public static <T> T get(String key,Class<T> classObject) {
		String object=jedis.opsForValue().get(key);
		return JSON.parseObject(object, classObject);
	}
	
	public static void set(String key,Object object) {
		String value=JSON.toJSONString(object);
		jedis.opsForValue().set(key,value);
	}
	
	/**设置对象的过期时间默认单位为秒
	 * 
	 * @param key
	 * @param object
	 * @param timeout
	 */
	public static void set(String key,Object object,long timeout) {
		String value=JSON.toJSONString(object);
		jedis.opsForValue().set(key,value, timeout,TimeUnit.SECONDS);
	}
	
	/**删除自定的key
	 * @param key
	 * @return
	 */
	public static Boolean del(String key) {
		return jedis.delete(key);
	}
	/**判断key是否已经存在
	 * 
	 * @param key
	 * @return
	 */
	public static Boolean exist(String key) {
		return jedis.hasKey(key);
	}
	
	/**key的剩余有效时间
	 * 
	 * @param key
	 * @return
	 */
	public static Long getTtl(String key) {
		return jedis.getExpire(key);
	}
	
	/**设置过期时间
	 * 单位为秒
	 * @param key
	 * @param timeout
	 * @return
	 */
	public static Boolean expire(String key, final long timeout) {
		return jedis.expire(key, timeout, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param key
	 * @param object
	 * @return 返回队列长度
	 */
	public static Long pushMessage(String key,Object object ) {
		String value=JSON.toJSONString(object);
		return jedis.opsForList().leftPush(key, value);
	}

	//模糊查询
	public static Set<String> keys(String keyName) {
		// TODO Auto-generated method stub
		return jedis.keys(keyName+ "*");
	}


	public static Long lPush(String listName,List<String> ids){
		// TODO Auto-generated method stub
		return jedis.opsForList().rightPushAll(listName,ids); 
	}
}
