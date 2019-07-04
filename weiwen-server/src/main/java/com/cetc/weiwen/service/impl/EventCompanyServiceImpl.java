package com.cetc.weiwen.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Company;
import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.CompanyMapper;
import com.cetc.weiwen.mapper.EventCompanyMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.EventCompanyService;
import com.cetc.weiwen.vo.EventCompanyVo;


@Service
public class EventCompanyServiceImpl implements EventCompanyService {
	
	protected static final Logger logger = LoggerFactory.getLogger(EventOrganizationServiceImpl.class);
	
	@Autowired
	private EventCompanyMapper eventComMapper;
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public int insertEventCompany(EventCompany eventCompany) {
		// TODO Auto-generated method stub
		return 0;//eventComMapper.insertEventCompany(eventCompany);
	}

	@Override
	public int insertPartEventCompany(EventCompany eventCompany) {
		// TODO Auto-generated method stub
		return 0;//eventComMapper.insertPartEventCompany(eventCompany);
	}

	@Override
	@Transactional
	public List<EventCompanyVo> queryEventComVoList(EventCompany eventCompany) {
		List<EventCompanyVo> eventCompanyVoList;
		try {
			eventCompanyVoList =null;// eventComMapper.queryEventComVoList(eventCompany);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventCompanyVoList;
	}

	@Override
	@Transactional
	public int batchInsertEventCom(List<EventCompany> eventCompanyList, int eventId) {
		
		for (EventCompany eventCompany : eventCompanyList) {
			eventCompany.setEventId(eventId);
		}
		
		int num;
		try {
			num = 0;//eventComMapper.batchInsertEventCom(eventCompanyList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public List<EventCompany> getEventCompanyList(EventCompany eventCompany) {
		List<EventCompany> eventCompanyList;
		try {
			eventCompanyList = eventComMapper.getEventCompanyList(eventCompany);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventCompanyList;
	}

	@Override
	public int deleteEventCompany(EventCompany eventCompany) {
		int num;
		try {
			num = eventComMapper.deleteEventCompany(eventCompany);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}


}
