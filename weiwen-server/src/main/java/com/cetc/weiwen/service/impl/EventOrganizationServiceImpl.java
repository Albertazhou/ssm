package com.cetc.weiwen.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.EventMapper;
import com.cetc.weiwen.mapper.EventOrganizationMapper;
import com.cetc.weiwen.mapper.OrganizationMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.EventOrganizationService;
import com.cetc.weiwen.vo.EventOrganizationVo;

/**
 * 事件与组织机构处理业务层
 * @author jhl
 * @date 2018年7月30日 上午11:21:14
 * @version 1.0 
 *
 */
@Service
public class EventOrganizationServiceImpl implements EventOrganizationService {
	
	protected static final Logger logger = LoggerFactory.getLogger(EventOrganizationServiceImpl.class);
	
	@Autowired
	private EventOrganizationMapper eventOrgMapper;
	
	@Autowired
	private OrganizationMapper orgMapper;
	
	@Autowired
	private EventMapper eventMapper;

	@Override
	public int insertMediaOrg(EventOrganization eventOrganization) {
		// TODO Auto-generated method stub
		return 0;//eventOrgMapper.insertMediaOrg(eventOrganization);
	}

	@Override
	@Transactional
	public int batchInsertEventOrg(List<EventOrganization> eventOrgList, Integer eventId) {
		// TODO Auto-generated method stub
		for(int i = 0; i < eventOrgList.size(); i++) {
			eventOrgList.get(i).setEventId(eventId);
		}
		int effectNum;
		try {
			effectNum =0;// eventOrgMapper.batchInsertEventOrg(eventOrgList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		
		return effectNum;
	}

	/**
	 * 根据id获取事件与组织机构的信息
	 */
	@Override
	public List<EventOrganizationVo> queryEventOrgVoList(Integer eventId) {
		EventOrganization eventOrg = new EventOrganization();
		eventOrg.setEventId(eventId);
		List<EventOrganizationVo> eventOrgVoList;
		try {
			eventOrgVoList = null;//eventOrgMapper.queryEventOrgVoList(eventOrg);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventOrgVoList;
	}

	@Override
	public int insertEventOrg(EventOrganization eventOrg) {
		Organization org;
		/**
		 * 
		
		try {
			org = orgMapper.getOrganizationById(eventOrg.getOrgId());
		} catch (Exception e3) {
			logger.error(e3.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(org == null) {
			return -1;
		}
		Event e;
		try {
			e = eventMapper.queryEventById(eventOrg.getEventId());
		} catch (Exception e2) {
			logger.error(e2.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(e == null) {
			return -1;
		}
		
		int num;
		try {
			num = eventOrgMapper.insert(eventOrg);
		} catch (Exception e1) {
			logger.error(e1.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		*/
		return 0;
		 
	}

	@Override
	public int deleteEventOrg(EventOrganization eventOrg) {
		//判断是否存在该事件
		/**
		 * 
		 
		Event e;
		try {
			e = eventMapper.queryEventById(eventOrg.getEventId());
		} catch (Exception e2) {
			logger.error(e2.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(e == null || e.getStatus() == 2) {
			return -1;
		}
		
		//查看是否存在该组织机构
		Organization org;
		try {
			org = orgMapper.getOrganizationById(eventOrg.getOrgId());
		} catch (Exception e3) {
			logger.error(e3.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(org == null) {
			return -1;
		}
		
		if(e.getStatus() == 0) {
			
		}
		*/
		return 0;
	}

}
