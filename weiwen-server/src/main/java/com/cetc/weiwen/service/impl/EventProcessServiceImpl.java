package com.cetc.weiwen.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.Education;
import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.entity.EventProcess;
import com.cetc.weiwen.entity.EventUser;
import com.cetc.weiwen.entity.Possession;
import com.cetc.weiwen.entity.Prosecute;
import com.cetc.weiwen.entity.SmsInfo;
import com.cetc.weiwen.entity.Task;
import com.cetc.weiwen.entity.TaskSign;
import com.cetc.weiwen.entity.UnifyReply;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.EducationMapper;
import com.cetc.weiwen.mapper.EventCivicsMapper;
import com.cetc.weiwen.mapper.EventProcessMapper;
import com.cetc.weiwen.mapper.EventUserMapper;
import com.cetc.weiwen.mapper.PossessionMapper;
import com.cetc.weiwen.mapper.ProsecuteMapper;
import com.cetc.weiwen.mapper.SmsInfoMapper;
import com.cetc.weiwen.mapper.TaskMapper;
import com.cetc.weiwen.mapper.TaskSignMapper;
import com.cetc.weiwen.mapper.UnifyReplyMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.EventProcessService;
import com.cetc.weiwen.vo.EducationVo;
import com.cetc.weiwen.vo.EventCivicsVo;
import com.cetc.weiwen.vo.EventUserVo;
import com.cetc.weiwen.vo.PossessionVo;
import com.cetc.weiwen.vo.ProsecuteVo;
import com.cetc.weiwen.vo.SmsInfoVo;
import com.cetc.weiwen.vo.TaskSignVo;
import com.cetc.weiwen.vo.UnifyReplyVo;

/**
 * 事件流程
 * @author jhl
 * @date 2018年9月10日 上午10:51:00
 * @version 1.0 
 *
 */
@Service
public class EventProcessServiceImpl implements EventProcessService {
	
	protected final Logger log = LoggerFactory.getLogger(EventProcessServiceImpl.class);

	@Autowired
	private EventProcessMapper eventProcessMapper;
	
	@Autowired
	private EventUserMapper eventUserMapper;
	
	@Autowired
	private EventCivicsMapper eventCivicsMapper;
	
	@Autowired
	private SmsInfoMapper smsInfoMapper;
	
	@Autowired
	private ProsecuteMapper prosecuteMapper;
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private TaskSignMapper taskSignMapper;
	
	@Autowired
	private EducationMapper educationMapper;
	
	@Autowired
	private PossessionMapper possessionMapper;
	
	@Autowired
	private UnifyReplyMapper unifyReplyMapper;
	
	/**
	 * 获取事件流程实体类
	 */
	@Override
	public EventProcess queryEventProcess(EventProcess eventProcess) {
		EventProcess eventPro;
		try {
			eventPro = eventProcessMapper.queryEventProcess(eventProcess);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return eventPro;
	}

	@Override
	public List<Map<String, Object>> getEventProcessList(EventProcess eventProcess) {
		List<Map<String,Object>> mapList = new ArrayList<>();
		EventProcess eventPro;
		try {
			eventPro = eventProcessMapper.queryEventProcess(eventProcess);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(eventPro == null) {
			return mapList;
		}
		if(eventPro.getEventId() == null) {
			return mapList;
		}
		//获取创建事件或者编辑事件的用户信息
		EventUser eventUser = new EventUser();
		eventUser.setEventId(eventPro.getEventId());
		List<EventUserVo> eventUserVoList;
		try {
			eventUserVoList = eventUserMapper.getEventUserVoListByEventUser(eventUser);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(eventUserVoList.size() > 0){ 
			for (EventUserVo euVo : eventUserVoList) {
				if(euVo.getType() == 0) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", euVo.getUser().getRealName());
					map.put("photo", euVo.getUser().getPhoto());
					map.put("time", euVo.getCreateTime());
					map.put("title", "录入事件");
					mapList.add(map);
					map = null;
				}else {
					//编辑事件的用户信息
					Map<String,Object> map = new HashMap<>();
					map.put("username", euVo.getUser().getRealName());
					map.put("photo", euVo.getUser().getPhoto());
					map.put("time", euVo.getCreateTime());
					map.put("title", "编辑了事件信息");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		//获取添加涉事人员的用户信息
		if(eventPro.getFace() != null && eventPro.getFace() == 1) {
			EventCivics eventCivics = new EventCivics();
			eventCivics.setEventId(eventPro.getEventId());
			List<EventCivicsVo> eventCivicsVoList;
			try {
				eventCivicsVoList = eventCivicsMapper.getEventCivicsVoList(eventCivics);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(eventCivicsVoList.size() > 0) {
				for (EventCivicsVo ecVo : eventCivicsVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", ecVo.getUser().getRealName());
					map.put("photo", ecVo.getUser().getPhoto());
					map.put("time", ecVo.getCreateTime());
					map.put("title", "人脸识别，自动添加涉事人员/单位");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		//获取发送执法信息的用户信息
		if(eventPro.getMessage() != null && eventPro.getMessage() == 1) {
			SmsInfo smsInfo = new SmsInfo();
			smsInfo.setEventId(eventPro.getEventId());
			List<SmsInfoVo> smsInfoVoList;
			try {
				smsInfoVoList = smsInfoMapper.getSmsInfoVoList(smsInfo);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(smsInfoVoList.size() > 0) {
				for (SmsInfoVo smsInfoVo : smsInfoVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", smsInfoVo.getUser().getRealName());
					map.put("photo", smsInfoVo.getUser().getPhoto());
					map.put("time", smsInfoVo.getCreateTime());
					map.put("title", "向涉事人员发送执法警告/敬告短信");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		//获取添加依法处置的用户信息
		if(eventPro.getProsecute() != null && eventPro.getProsecute() == 1){
			Prosecute prosecute = new Prosecute();
			prosecute.setEventId(eventPro.getEventId());
			
			List<ProsecuteVo> prosecuteVoList;
			try {
				prosecuteVoList = prosecuteMapper.getProsecuteVoList(prosecute);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(prosecuteVoList.size() > 0) {
				for (ProsecuteVo proseVo : prosecuteVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", proseVo.getUser().getRealName());
					map.put("photo", proseVo.getUser().getPhoto());
					map.put("time", proseVo.getCreateTime());
					map.put("title", "依法处置");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		//获取现场签到的用户信息
		if(eventPro.getSign() != null && eventPro.getSign() == 1){
			
			Task task = new Task();
			task.setEventId(eventPro.getEventId());
			task.setType(1);
			List<Task> taskList;
			try {
				taskList = taskMapper.getTaskListByTask(task);
			} catch (Exception e1) {
				log.error(e1.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			for (Task t : taskList) {
				TaskSign taskSign = new TaskSign();
				taskSign.setTaskId(t.getId());
				
				List<TaskSignVo> taskSignVoList;
				try {
					taskSignVoList = taskSignMapper.getTaskSignVoList(taskSign);
				} catch (Exception e) {
					log.error(e.getMessage());
					throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
				}
				if(taskSignVoList.size() > 0) {
					for (TaskSignVo taskSignVo : taskSignVoList) {
						Map<String,Object> map = new HashMap<>();
						map.put("username", taskSignVo.getUser().getRealName());
						map.put("photo", taskSignVo.getUser().getPhoto());
						map.put("time", taskSignVo.getCreateTime());
						map.put("title", "现场签到");
						mapList.add(map);
						map = null;
					}
				}
			}
			
		}
		
		if(eventPro.getEducation() != null && eventPro.getEducation() == 1) {
			Education education = new Education();
			education.setEventId(eventPro.getEventId());
			List<EducationVo> educationVoList;
			try {
				educationVoList = educationMapper.getEducationVoList(education);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(educationVoList.size() > 0) {
				for (EducationVo educationVo : educationVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", educationVo.getUser().getRealName());
					map.put("photo", educationVo.getUser().getPhoto());
					map.put("time", educationVo.getCreateTime());
					map.put("title", "法制教育");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		if(eventPro.getPossession() != null && eventPro.getPossession() == 1) {
			Possession possession = new Possession();
			possession.setEventId(eventPro.getEventId());
			List<PossessionVo> posVoList;
			try {
				posVoList = possessionMapper.getPossessionVoList(possession);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(posVoList.size() > 0) {
				for (PossessionVo possessionVo : posVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", possessionVo.getUser().getRealName());
					map.put("photo", possessionVo.getUser().getPhoto());
					map.put("time", possessionVo.getCreateTime());
					map.put("title", "属地带回");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		if(eventPro.getReply() != null && eventPro.getReply() == 1) {
			UnifyReply unifyReply = new UnifyReply();
			unifyReply.setEventId(eventPro.getEventId());
			List<UnifyReplyVo> replyVoList;
			try {
				replyVoList = unifyReplyMapper.getUnifyReplyVoList(unifyReply);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
			}
			if(replyVoList.size() > 0) {
				for (UnifyReplyVo unifyReplyVo : replyVoList) {
					Map<String,Object> map = new HashMap<>();
					map.put("username", unifyReplyVo.getUser().getRealName());
					map.put("photo", unifyReplyVo.getUser().getPhoto());
					map.put("time", unifyReplyVo.getCreateTime());
					map.put("title", "统一答复");
					mapList.add(map);
					map = null;
				}
			}
		}
		
		//对所有内容进行排序
		if(mapList.size() > 0) {
			listSort(mapList);
		}
		return mapList;
	}
	
	/**
	 * 根据时间进行排序
	 * @param list
	 */
	private void listSort(List<Map<String,Object>> mapList) {
        Collections.sort(mapList, new Comparator<Map<String,Object>>() {
            @Override
            public int compare(Map<String,Object> m1, Map<String,Object> m2) {
                try {
                	Date dt1 = (Date) m1.get("time");
                	Date dt2 = (Date) m2.get("time");
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

}
