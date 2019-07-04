package com.cetc.weiwen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.PeopleNum;
import com.cetc.weiwen.mapper.PeopleNumMapper;
import com.cetc.weiwen.service.PeopleNumService;

@Service
public class PeopleNumServiceImpl implements PeopleNumService {

	@Autowired
	private PeopleNumMapper peopleNumMapper;
	
	
	@Override
	public List<PeopleNum> getpeopleNumList() {
		// TODO Auto-generated method stub
		return null;//peopleNumMapper.getpeopleNumMapper();
	}

}
