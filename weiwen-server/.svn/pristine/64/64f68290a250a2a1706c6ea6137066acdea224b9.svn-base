package com.cetc.weiwen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.EventMapper;
import com.cetc.weiwen.mapper.EventOrganizationMapper;
import com.cetc.weiwen.mapper.EventUserMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.result.ResultEnums;
import com.cetc.weiwen.result.ResultExecution;
import com.cetc.weiwen.service.EventUserService;
import com.cetc.weiwen.vo.EventOrganizationVo;
import com.cetc.weiwen.vo.EventUserVo;

/**
 * 事件与用户关联表的业务层实现类
 * @author jhl
 * @date 2018年8月6日 上午10:25:44
 * @version 1.0 
 *
 */
@Service
public class EventUserServiceImpl implements EventUserService {
	
	protected static final Logger logger = LoggerFactory.getLogger(EventUserServiceImpl.class);
	
	@Autowired
	private EventUserMapper eventUserMapper;
	
	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private EventOrganizationMapper eventOrgMapper;

	@Override
	public int insertEventUser(EventUser eventUser) {
		int num;
		try {
			num = 0;//eventUserMapper.insertEventUser(eventUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public int insertPartEventUser(EventUser eventUser) {
		int num;
		try {
			num = 0;// eventUserMapper.insertPartEventUser(eventUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public List<EventUserVo> queryEventUserVoByEventUser(EventUser eventUser) {
		List<EventUserVo> eventUserVoList = new ArrayList<>();
		try {
			eventUserVoList =null;// eventUserMapper.queryEventUserVoByEventUser(eventUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventUserVoList;
	}

	@Override
	public List<Event> getEventByUserId(EventUser eventUser) {
		List<Event> eventList = new ArrayList<>();
		List<EventUser> eventUserList;
		try {
			eventUserList = null;//eventUserMapper.getEventByUserId(eventUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(eventUserList.size() > 0) {
			for (EventUser eventUserTemp : eventUserList) {
				//根据事件id查询事件
				Event event;
				try {
					event = null;//eventMapper.queryEventById(eventUserTemp.getEventId());
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
				}
				//判断是否为空，因为有可能该事件已经过期或者已删除
				if(event != null) {
					eventList.add(event);
				}
			}
		}
		return eventList;
	}

	@Override
	public int deleteEventUser(EventUser eventUser) {
		// TODO Auto-generated method stub
		return 0;//eventUserMapper.deleteEventUser(eventUser);
	}

	@Override
	@Transactional
	public ResultExecution<EventUser> addEventUserByUserList(List<User> userList) {
		ResultExecution<EventUser> resultExecution = new ResultExecution<EventUser>();
		if(userList.size() <= 0) {
			resultExecution.setState(ResultEnums.NULL_INFO.getState());
			return resultExecution;
		}
		for (User user : userList) {
			//int orgId = user.getOrgId();
			EventOrganization eventOrg = new EventOrganization();
		//	eventOrg.setOrgId(orgId);
			List<EventOrganizationVo> eventOrgVoList;
			try {
				eventOrgVoList =null;// eventOrgMapper.queryEventOrgVoList(eventOrg);
			} catch (Exception e1) {
				logger.error(e1.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(eventOrgVoList.size() > 0) {
				for (EventOrganizationVo eventOrganizationVo : eventOrgVoList) {
					EventUser eventUser = new EventUser();
					eventUser.setCreateTime(new Date());
				   //eventUser.setLastEditTime(new Date());
					eventUser.setEventId(eventOrganizationVo.getEventId());
					eventUser.setUserId(user.getId());
					int num;
					try {
						num = 0;//eventUserMapper.insertEventUser(eventUser);
					} catch (Exception e) {
						logger.error(e.getMessage());
						throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
					}
					if(num <= 0) {
						resultExecution.setState(ResultEnums.INSTER_FAIL.getState());
						return resultExecution;
					}
				}
			}
		}
		resultExecution.setState(ResultEnums.SUCCESS.getState());
		return resultExecution;
	}

	@Override
	@Transactional
	public ResultExecution<EventUser> removeEventUserByUserList(List<User> userList) {
		ResultExecution<EventUser> resultExecution = new ResultExecution<EventUser>();
		if(userList.size() <= 0) {
			resultExecution.setState(ResultEnums.NULL_INFO.getState());
			return resultExecution;
		}
		for (User user : userList) {
			EventUser eventUser = new EventUser();
			eventUser.setUserId(user.getId());
			//判断有没有存在该用户与事件的关系，若不存在不需要删除
			List<EventUser> eventUserList;
			try {
				eventUserList = null;//eventUserMapper.getEventByUserId(eventUser);
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(eventUserList.size() > 0) {
				int num;
				try {
					num =0;// eventUserMapper.deleteEventUser(eventUser);
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
				}
				if(num <= 0) {
					resultExecution.setState(ResultEnums.DELETE_FAIL.getState());
					return resultExecution;
				}
			}
		}
		resultExecution.setState(ResultEnums.SUCCESS.getState());
		return resultExecution;
	}

	@Override
	public int updateEventUserById(EventUser eventUser) {
		// TODO Auto-generated method stub
		return eventUserMapper.updateEventUserById(eventUser);
	}

}
