package com.cetc.weiwen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.entity.EventOrganization;
import com.cetc.weiwen.entity.EventProcess;
import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.EventCompanyMapper;
import com.cetc.weiwen.mapper.EventMapper;
import com.cetc.weiwen.mapper.EventOrganizationMapper;
import com.cetc.weiwen.mapper.EventProcessMapper;
import com.cetc.weiwen.mapper.EventUserMapper;
import com.cetc.weiwen.mapper.MediaMapper;
import com.cetc.weiwen.mapper.UserMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.CompanyService;
import com.cetc.weiwen.service.EventService;
import com.cetc.weiwen.vo.EventOrganizationVo;
import com.cetc.weiwen.vo.EventReceive;
import com.cetc.weiwen.vo.EventUserVo;
import com.cetc.weiwen.vo.EventVo;

@Service
public class EventServiceImpl implements EventService {

	protected static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private EventUserMapper eventUserMapper;
	
	@Autowired
	private EventProcessMapper eventProcessMapper;
	
	@Autowired
	private EventCompanyMapper eventCompanyMapper;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private MediaMapper mediaMapper;
	
	@Autowired
	private EventOrganizationMapper eventOrgMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteEventById(Integer id, Integer chatStatus) {
		Event event = new Event();
		if(chatStatus == null) {
			chatStatus = 2;
		}else if(chatStatus == 1) {
			event.setPhase(2);
		}
		event.setStatus(chatStatus);
		event.setId(id);
		event.setLastEditTime(new Date());
		int num;
		try {
			num = eventMapper.updateEventById(event);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(num > 0) {
			return num;
		}else {
			logger.warn("删除用户失败！");
			return 0;
		}
		
	}

	/**
	 * 新增事件，同时处理与之相关联的数据表
	 */
	@Override
	@Transactional
	public int createEvent(EventReceive eventReceive,User user) {
		//插入事件表
		Event event = eventReceive.getEvent();
		event.setCreateTime(new Date());
		int num;
		event.setLastEditTime(new Date());
		try {
			num = eventMapper.insertEvent(event);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(num <= 0) {
			return -1;
		}
		//插入事件流程
		EventProcess eventProcess = new EventProcess();
		eventProcess.setEventId(event.getId());
		int effected;
		try {
			effected = eventProcessMapper.insertEventProcess(eventProcess);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(effected <= 0) {
			return -1;
		}
		
		//插入操作该事件的用户类型
		int number = this.handleEventUser(event,user,0);
		if(number <= 0) {
			return -1;
		}
		//插入多媒体信息
		List<Integer> mediaIds = eventReceive.getAddMediaIds();
		if(mediaIds != null && mediaIds.size() > 0) {
			int mNum;
		    mNum = mediaMapper.updateGeneralIdAndFunTypeById(event.getId(),0,mediaIds);
			if(mNum <= 0) {
				return -1;
			}
		}
		//插入事件与组织机构的关系
		List<EventOrganization> eventOrgList = eventReceive.getAddEventOrgList();
		if(eventOrgList != null && eventOrgList.size() > 0) {
			for (EventOrganization eventOrganization : eventOrgList) {
				eventOrganization.setEventId(event.getId());
			}
			int eoNum;
			try {
				eoNum = eventOrgMapper.batchInsertEventOrg(eventOrgList);
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(eoNum <= 0) {
				return -1;
			}
		}
		
		//插入事件与公司的关系
		List<EventCompany> eventCompanyList = eventReceive.getAddEventCompanyIds();
		if(eventCompanyList != null && eventCompanyList.size() > 0) {
			for (EventCompany eventCompany : eventCompanyList) {
				eventCompany.setEventId(event.getId());
				//同时将公司信息插入公司表
				companyService.save(eventCompany);
			}
			int ecNum;
			try {
				ecNum = eventCompanyMapper.batchInsertEventCompany(eventCompanyList);
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(ecNum <= 0) {
				return -1;
			}
		}
		return num;
	}
	@Override
	public int insertPartEvent(Event event) {
		// TODO Auto-generated method stub
		int effectNum;
		try {
			effectNum = 0;//eventMapper.insertEvent(event);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return effectNum;
	}

	@Override
	public Event queryEventById(Integer id) {
		// TODO Auto-generated method stub
		Event event;
		try {
			event=eventMapper.queryEventById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(event != null) {
			return event;
		}else {
			return null;
		}
	}

	@Override
	public int updateEventById(Event event) {
		// TODO Auto-generated method stub
		int effectNum;
		try {
			effectNum = 0;//eventMapper.updateEventById(event);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(effectNum > 0) {
			return effectNum;
		}else {
			return 0;
		}
	}

	@Override
	public List<Event> queryEventByIdAndEventName(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;//eventMapper.queryEventByIdAndEventName( id, name);
	}

	@Override
	public int updatePassEventByEvent(Event event) {
		return 0;// eventMapper.updatePassEventByEvent(event);
	}

	@Override
	@Transactional
	public int insertEventByOrgList(Event event, List<EventOrganization> eventOrgList) {
		List<EventUser> eventUserList = new ArrayList<>();
		int num;
		try {
			num = 0;//eventMapper.insertEvent(event);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		//当事件插入成功后再进行事件与用户的操作
		if(num > 0) {
			List<User> allUserList = new ArrayList<>();
			for (EventOrganization eventOrganization : eventOrgList) {
				List<User> userList;
				try {
					userList = null;//userMapper.queryUserByOrgId(eventOrganization.getOrgId());
				} catch (Exception e) {
					logger.error(e.getMessage());
					throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
				}
				allUserList.addAll(userList);
			}
			for (User user : allUserList) {
				EventUser  eventUser = new EventUser();
				eventUser.setEventId(event.getId());
				eventUser.setCreateTime(new Date());
				eventUser.setUserId(user.getId());
				//eventUser.setLastEditTime(new Date());
				eventUserList.add(eventUser);
				eventUser = null;
			}
			int effectNum;
			try {
				effectNum =0;// eventUserMapper.batchInsertEventUser(eventUserList);
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			return effectNum;
		}
		return 0;
	}

	@Override
	@Transactional
	public int updateEvent(EventReceive eventReceive, User user) {
		Event event=eventReceive.getEvent();
		Event e;
		e = eventMapper.queryEventById(event.getId());
		if(e == null) {
			return -2;	
		}
		//更新操作用户
		int num = 0;
		int number = this.handleEventUser(event,user,1);
		if(number <= 0) {
			return -1;
		}
		//更新事件信息
		num = eventMapper.updateEventById(event);
		if(num <= 0) {
			return -1;
		}
		//删除多媒体信息
		List<Integer> delMediaList=eventReceive.getDelMediaIds();
		if(delMediaList!=null&&delMediaList.size()>0){
			mediaMapper.updateGeneralIdAndFunTypeById(-1,5,delMediaList);
		}
		//插入多媒体信息
		List<Integer> addMediaList=eventReceive.getAddMediaIds();
		if(addMediaList!=null&&addMediaList.size()>0){
			mediaMapper.updateGeneralIdAndFunTypeById(e.getId(),0,addMediaList);
		}
		//插入新的涉事公司数据
		List<EventCompany> addEventCompany=eventReceive.getAddEventCompanyIds();
		if(addEventCompany!=null&&addEventCompany.size()>0){
			for (EventCompany eventCompany : addEventCompany) {
				eventCompany.setEventId(event.getId());
				companyService.save(eventCompany);
			}
			//同时将公司信息插入公司表
			eventCompanyMapper.batchInsertEventCompany(addEventCompany);
		}
		//删除涉事公司
		List<Integer> delEventCIds=eventReceive.getDelEventCompanyIds();
		if(delEventCIds!=null&&delEventCIds.size()>0){
			eventCompanyMapper.batchDeleteEventCompany(e.getId(), delEventCIds);
		}
		//修改涉事公司
		List<EventCompany> editEventCompanyList=eventReceive.getEditEventCompanyIds();
		if(editEventCompanyList!=null&&editEventCompanyList.size()>0){
			for (EventCompany eventCompany : editEventCompanyList) {
				eventCompany.setEventId(event.getId());
				companyService.save(eventCompany);
			}
			eventCompanyMapper.batchUpdateEventCompany(editEventCompanyList);
		}
		//新增组织相关职能部门信息
		List<EventOrganization> addEventOrgList=eventReceive.getAddEventOrgList();
		if(addEventOrgList!=null&&addEventOrgList.size()>0){
			for(EventOrganization eo:addEventOrgList) {
				eo.setEventId(e.getId());
			}
			eventOrgMapper.batchInsertEventOrg(addEventOrgList);
			if(e.getStatus().equals(1)) {
				  //建立用户与事件的关系
				  List<EventUser> addEventUser=new ArrayList<EventUser>();
				  for(EventOrganization eo:addEventOrgList){
					 List<User> users=userMapper.getUserListByOrgId(eo.getOrgId());
					 for(User u:users) {
						 EventUser eu=new EventUser();
						 eu.setEventId(e.getId());
						 eu.setUserId(u.getId());
						 addEventUser.add(eu);
					 }
				  }
				 eventUserMapper.batchInsertEventUser(addEventUser);
			}
		}
		//删除组织相关职能部门信息
		List<Integer> delEventOrgIds=eventReceive.getDelEventOrgIds();
		if(delEventOrgIds!=null&&delEventOrgIds.size()>0){
			eventOrgMapper.batchDeleteEventOrg(e.getId(),delEventOrgIds);
			//事件审核通过
			if(e.getStatus().equals(1)) {
			  //删除事件与用户的关系
			  List<Integer> delIds=new ArrayList<Integer>();
			  for(Integer id:delEventOrgIds){
				 List<User> users=userMapper.getUserListByOrgId(id);
				 for(User u:users) {
					 delIds.add(u.getId());
				 }
			  }
			 eventUserMapper.batchDelteEventUser(e.getId(),delIds);
			}
		}
		return num;
	}
	
	/**
	 * 添加事件与用户的关系
	 * @param event
	 * @param user
	 * @return
	 */
	private int handleEventUser(Event event,User user,int status) {
		EventUser eventUser = new EventUser();
		eventUser.setUserId(user.getId());
		eventUser.setEventId(event.getId());
		EventUser eu=eventUserMapper.queryEventUserById(eventUser);
		eventUser.setType(status);
		eventUser.setCreateTime(new Date());
		int number;
		try {
			//记录已经存在
			if(eu==null) {
			 number = eventUserMapper.insertEventUser(eventUser);
			}else {
			 eventUser.setVersion(eu.getVersion());
			 number = eventUserMapper.updateEventUserById(eventUser);	
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return number;
	}
	@Override
	public List<EventVo> getEventListOrder(Integer order, Integer userId) {
		
		return eventMapper.getEventListOrder( order,  userId);
	}


	@Override
	public Map<String, Object> getEventDetailInfo(Integer eventId) {
		Map<String, Object> map = new HashMap<String, Object>();
		EventUser eventUser = new EventUser();
		eventUser.setEventId(eventId);
		eventUser.setType(0);
		EventUserVo eventUserVo;
		try {
			eventUserVo = eventUserMapper.getEventUserVo(eventUser);
		} catch (Exception e1) {
			logger.error(e1.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(eventUserVo == null) {
			return map;
		}
		EventOrganization eventOrg = new EventOrganization();
		eventOrg.setEventId(eventId);
		List<EventOrganizationVo> eventOrgVoList;
		try {
			eventOrgVoList = eventOrgMapper.getEventOrgVoList(eventOrg);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(eventOrgVoList.size() < 0) {
			return map;
		}
		
		Media media = new Media();
		media.setGeneralId(eventUserVo.getEvent().getId());
		media.setFunType(0);;
		List<Media> mediaList;
		try {
			mediaList = mediaMapper.getMediaList(media);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(mediaList.size() < 0) {
			return map;
		}
		
		EventCompany eventCompany = new EventCompany();
		eventCompany.setEventId(eventUserVo.getEvent().getId());
		List<EventCompany> eventCompanyList;
		try {
			eventCompanyList = eventCompanyMapper.getEventCompanyList(eventCompany);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		
		if(eventCompanyList.size() < 0) {
			return map;
		}
		map.put("mediaList", mediaList);
		map.put("eventCompanyList", eventCompanyList);
		map.put("eventVo", eventUserVo);
		map.put("eventOrgList", eventOrgVoList);
		return map;
	}

	@Override
	public Integer setEventTop(Integer eventId, Long top, Integer userId) {
		EventUser eventUser=new EventUser();
		eventUser.setUserId(userId);
		eventUser.setEventId(eventId);
		top=top.equals(0L)?0L:System.currentTimeMillis();
		eventUser.setTopping(top);
		return eventUserMapper.updateEventUserById(eventUser);
	}
//	//对象进行去重
//	private static <T> List<T>  operationSet(List<T> newList,List<T> oldList) {
//		List<T> temp=new ArrayList<>();
//		for(T i:newList) {
//			for(T j:oldList) {
//				if(i.equals(j)) {
//					temp.add(i);
//				}
//			}
//		}
//		newList.removeAll(temp);
//		oldList.removeAll(temp);
//		return temp;
//	}
	
	@Override
	public List<Event> getUserEvent( String name,Integer id) {
		// TODO Auto-generated method stub

		return  queryEventByIdAndEventName(id,name);
	}
	
	
}
