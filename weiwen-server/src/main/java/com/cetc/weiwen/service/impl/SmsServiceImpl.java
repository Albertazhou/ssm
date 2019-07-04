package com.cetc.weiwen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Civics;
import com.cetc.weiwen.entity.SmsInfo;
import com.cetc.weiwen.mapper.CivicsMapper;
import com.cetc.weiwen.mapper.SmsInfoMapper;
import com.cetc.weiwen.service.SmsService;
import com.cetc.weiwen.vo.SmsParam;

@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	private CivicsMapper civicsMapper;
	
	@Autowired
	private SmsInfoMapper smsInfoMapper;
	/**发送短信
	 * 
	 */
	@Override
	@Transactional
	public Integer sendSms(SmsParam smsParam,Integer id) {
		
		List<String> civicsIds=smsParam.getCivicsList();
		/*获取所有的公民信息*/
		List<Civics> civicsList=civicsMapper.getCivicsList(civicsIds);
		List<SmsInfo> smsInfoList=new ArrayList<SmsInfo>();
		//短信发送来源于任务
		if(null==smsParam.getTaskId()) {
		  //做任务todo
		  
		}
		//发送短信
		for(Civics civics:civicsList) {
			SmsInfo smsInfo=new SmsInfo();
			smsInfo.setCivicsIdcard(civics.getIdcard());
			smsInfo.setCreateTime(new Date());
			smsInfo.setUserId(id);
			smsInfo.setContent(smsParam.getSmsType());
			smsInfo.setEventId(smsParam.getEventId());
			smsInfo.setTaskId(null==smsParam.getTaskId()?null:smsParam.getTaskId());
			smsInfoList.add(smsInfo);
		}
		//调用第三方接口发送短信
		System.out.println("==============================短信发送成功================================");
		int code=smsInfoMapper.batchSmsInfo(smsInfoList);
		
		return code;
	}
	

}
