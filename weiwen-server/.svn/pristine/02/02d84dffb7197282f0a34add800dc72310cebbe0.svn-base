package com.cetc.weiwen.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.Civics;
import com.cetc.weiwen.entity.EventCivics;
import com.cetc.weiwen.entity.VisitRecord;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.CivicsMapper;
import com.cetc.weiwen.mapper.VisitRecordMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.CivicsService;
import com.cetc.weiwen.vo.EventCivicsVo;

@Service
public class CivicsServiceImpl implements CivicsService {

	protected static final Logger logger = LoggerFactory.getLogger(CivicsServiceImpl.class);
	
	@Autowired
	private CivicsMapper civicsMapper;
	
	@Autowired
	private VisitRecordMapper visitRecordMapper;


	@Override
	public int deleteCivicsById(String idcard) {
		// TODO Auto-generated method stub
		return 0;//civicsMapper.deleteCivicsById(idcard);
	}

	@Override
	public int insertCivics(Civics civics) {
		civics.setCreateTime(new Date());
		civics.setLastEditTime(new Date());
		int num;
		try {
			num = 0;//civicsMapper.insertCivics(civics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public int insertPartCivics(Civics civics) {
		civics.setCreateTime(new Date());
		civics.setLastEditTime(new Date());
		int num;
		try {
			num =0;// civicsMapper.insertPartCivics(civics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public Civics selectByIdcard(String idcard) {
		return civicsMapper.queryCivicsByIdcard(idcard);
	}

	@Override
	public int updatePartCivicsByIdcard(Civics civics) {
		civics.setLastEditTime(new Date());
		int num;
		try {
			num =0;// civicsMapper.updateCivicsByIdcard(civics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public int updateCivicsByIdcard(Civics civics) {
		civics.setLastEditTime(new Date());
		int num;
		try {
			num =0;// civicsMapper.updatePartCivicsByIdcard(civics);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public Map<String,Object> queryCivicsListByEventId(Integer id, Integer num, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> ret=new HashMap<String,Object>();
		List<Civics> cList=null;
		if(num==null&&size==null){
			cList=null;// civicsMapper.queryCivicsListByEventId(id,null,null);	
		}else if(num!=null&&size!=null){
			cList=null;// civicsMapper.queryCivicsListByEventId(id,num*size,size);
		}else{
			ret.put("msg", "参数异常");
			return ret;
		}
		int total=0;//civicsMapper.countByEventId(id);
		ret.put("list", cList);
		ret.put("total", total);
		return ret;
	
	}

	@Override
	public Map<String, Object> getCivicsDetail(String idcard) {
		Map<String, Object> map = new HashMap<String, Object>();
		Civics civics;
		try {
			civics = civicsMapper.queryCivicsByIdcard(idcard);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(civics == null) {
			return map;
		}
		map.put("civics", civics);
		VisitRecord visitRecord = new VisitRecord();
		visitRecord.setIdcard(idcard);
		List<VisitRecord> visitRecordList;
		try {
			visitRecordList = visitRecordMapper.getVisitRecordList(visitRecord);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(visitRecordList.size() > 0) {
			map.put("visitRecord", visitRecordList);
		}
		return map;
	}
}
