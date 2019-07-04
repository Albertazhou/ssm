package com.cetc.weiwen.commons.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cetc.weiwen.commons.constant.Constant;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.mapper.EventMapper;
import com.cetc.weiwen.mapper.UserMapper;
/**
 * 创建程序是进行一系列初始化操作
 * @author liqiaofei
 * 2018年10月29日
 */
@Component
public class SysInitConfigRunner implements CommandLineRunner{

	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//mysql数据同步到redis
		Set<String> eventGroupUser= RedisUtils.keys(Constant.EVENT_GROUP_USER_EVENT_ID);
		if(eventGroupUser==null||eventGroupUser.size()<=0) {
			List<String> ids=new ArrayList<String>();
			List<Integer> eventIds=eventMapper.findAllEventId();
			for(Integer eventId:eventIds) {
				List<User> userList=userMapper.findUserListByEventId(eventId);
				for(User user:userList) {
					ids.add(user.getId().toString());
					RedisUtils.lPush(Constant.EVENT_GROUP_USER_EVENT_ID+eventId,ids);
				}
			}
			
		}
		
		
	}

}
