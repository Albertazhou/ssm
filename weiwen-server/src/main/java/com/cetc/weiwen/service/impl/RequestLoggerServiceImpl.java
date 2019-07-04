package com.cetc.weiwen.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.RequestLogger;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.RequestLoggerMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.RequestLoggerService;

/**
 * 操作日志业务层
 * @author jhl
 * @date 2018年9月14日 上午10:35:58
 * @version 1.0 
 *
 */
@Service
public class RequestLoggerServiceImpl implements RequestLoggerService {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestLoggerServiceImpl.class);

	@Autowired
	private RequestLoggerMapper requestLoggerMapper;
	
	@Override
	public int insertRequestLogger(RequestLogger requestLogger) {
		int num;
		try {
			num = requestLoggerMapper.insertRequestLogger(requestLogger);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

}
