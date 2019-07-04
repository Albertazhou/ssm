package com.cetc.weiwen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.EventType;
import com.cetc.weiwen.mapper.EventTypeMapper;
import com.cetc.weiwen.service.EventTypeService;

@Service
public class EventTypeServiceImpl implements EventTypeService {

	@Autowired
	private EventTypeMapper eventTypeMapper;
	
	@Override
	public List<EventType> getEventTypeLists() {
		// TODO Auto-generated method stub
		return null;// eventTypeMapper.getEventTypeLists();
	}

}
