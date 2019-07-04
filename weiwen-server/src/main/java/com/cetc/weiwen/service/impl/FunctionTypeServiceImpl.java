package com.cetc.weiwen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.mapper.FunctionTypeMapper;
import com.cetc.weiwen.service.FunctionTypeService;

@Service
public class FunctionTypeServiceImpl implements FunctionTypeService {
	
	@Autowired
	FunctionTypeMapper functionTypeMapper;

	@Override
	public boolean isExit(Integer id) {
		// TODO Auto-generated method stub
		if(functionTypeMapper.selectByPrimaryKey(id)!=null)
			return true;
		return false;
		
	}

}
