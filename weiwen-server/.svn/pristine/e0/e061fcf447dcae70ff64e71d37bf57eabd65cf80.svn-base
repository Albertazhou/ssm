package com.cetc.weiwen.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.EventCivicsMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.EventCivicsService;
import com.cetc.weiwen.vo.EventCivicsVo;

@Service
public class EventCivicsServiceImpl implements EventCivicsService {
	
	protected static final Logger logger = LoggerFactory.getLogger(EventCivicsServiceImpl.class);
	
	@Autowired
	private EventCivicsMapper eventCivicsMapper;

	@Override
	public int insertEventCivics(EventCivics eventCivics) {
		// TODO Auto-generated method stub
		return 0;//eventCivicsMapper.insertEventCivics(eventCivics);
	}

	@Override
	public int insertEventCivicsPart(EventCivics cventCivics) {
		// TODO Auto-generated method stub
		return 0;// eventCivicsMapper.insertEventCivicsPart(cventCivics);
	}

	@Override
	public List<EventCivicsVo> queryEventVoList(EventCivics eventCivics) {
		List<EventCivicsVo> eventCivicsVoList;
		try {
			eventCivicsVoList = eventCivicsMapper.getEventCivicsVoList(eventCivics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventCivicsVoList;
	}

	@Override
	@Transactional
	public int batchInsertEventCiv(List<EventCivics> eventCivicsList,int eventId) {
		
		//把事件的id设置进去
		for (EventCivics eventCivics : eventCivicsList) {
			eventCivics.setEventId(eventId);
			eventCivics.setCreateTime(new Date());
			eventCivics.setLastEditTime(new Date());
		}
		
		int num;
		try {
			num = 0;//eventCivicsMapper.batchInsertEventCiv(eventCivicsList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public List<EventCivics> getEventCivicsList(EventCivics eventCivics) {
		List<EventCivics> eventCivcisList;
		try {
			eventCivcisList = eventCivicsMapper.queryEventCivicsList(eventCivics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventCivcisList;
	}

}
