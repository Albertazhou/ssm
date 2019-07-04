package com.cetc.weiwen.service;

import com.cetc.weiwen.vo.SmsParam;

/**
 * 提供发送短信服务
 * @author liqiaofei
 * 2018年9月26日
 */
public interface SmsService {

	public Integer sendSms(SmsParam smsParam, Integer id);
}
