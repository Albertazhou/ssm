package com.cetc.weiwen.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.VisitRecord;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.VisitRecordMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

	protected final Logger log = LoggerFactory.getLogger(VisitRecordServiceImpl.class);
	
	@Autowired
	private VisitRecordMapper visitRecordMapper;
	
	@Override
	public List<VisitRecord> getVisitRecordList(String idcard) {
		VisitRecord visitRecord = new VisitRecord();
		visitRecord.setIdcard(idcard);
		List<VisitRecord> visitRecordList;
		try {
			visitRecordList = visitRecordMapper.getVisitRecordList(visitRecord);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return visitRecordList;
	}

}
