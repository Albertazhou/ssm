package com.cetc.weiwen.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Company;
import com.cetc.weiwen.entity.EventCompany;
import com.cetc.weiwen.entity.VisitRecord;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.CompanyMapper;
import com.cetc.weiwen.mapper.VisitRecordMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	protected static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private VisitRecordMapper visitRecordMapper;
	
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;//companyMapper.deleteById(id);
	}

	@Override
	public int insertCompany(Company company) {
		company.setCreateTime(new Date());
		company.setLastEditTime(new Date());
		int num;
		try {
			num = companyMapper.insertSelective(company);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public int insertPartCompany(Company company) {
		company.setCreateTime(new Date());
		company.setLastEditTime(new Date());
		int num;
		try {
			num =0;// companyMapper.insertPartCompany(company);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public Company queryCompanyById(Integer id) {
		// TODO Auto-generated method stub
		return null;//companyMapper.queryCompanyById(id);
	}

	@Override
	public int updateCompanyById(Company company) {
		company.setLastEditTime(new Date());
		int num;
		try {
			num = 0;//companyMapper.updateCompanyById(company);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public int updateCompanyPartById(Company company) {
		company.setLastEditTime(new Date());
		int num;
		try {
			num =0;// companyMapper.updateCompanyPartById(company);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return num;
	}

	@Override
	public Map<String, Object> queryCompanyListByEventId(Integer id, Integer num, Integer size) {
		// TODO Auto-generated method stub
		Map<String,Object> ret=new HashMap<String,Object>();
		List<Company> cList=null;
		if(num==null&&size==null){
			cList= null;//companyMapper.queryCompanyListByEventId(id,null,null);
		}else if(num!=null&&size!=null){
			cList=null;// companyMapper.queryCompanyListByEventId(id,num*size,size);
		}else{
			ret.put("msg", "参数异常");
			return ret;
		}
		int total=0;//companyMapper.countByEventId(id);
		ret.put("list", cList);
		ret.put("total", total);
		return ret;
	}

	@Override
	public Map<String, Object> queryCompanyDetail(Integer companyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Company company;
		try {
			company = companyMapper.getCompanyById(companyId);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		if(company == null) {
			return map;
		}
		map.put("company", company);
		VisitRecord visitRecord = new VisitRecord();
		visitRecord.setCompanyId(companyId);
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

	@Transactional
	@Override
	public int save(EventCompany eventCompany) {
		Company company;
		if(null!=eventCompany.getCompanyId()) {
			company=companyMapper.getCompanyById(eventCompany.getCompanyId());
			if(company!=null) {
				//更新公司信息
				updatCompany(eventCompany);
			}
		}else {
			//插入公司信息
			insertCompany(eventCompany);
		}
		
		return 1;
	}
	private void insertCompany(EventCompany eventCompany) {
    	Company company=new Company();
		company.setAddress(eventCompany.getAddress());
		company.setAttention(eventCompany.getAttention());
		company.setAttentionRank(eventCompany.getAttentionRank());
		company.setCompanyType(eventCompany.getCompanyType());
		company.setCreateTime(new Date());
		company.setCreditCode(eventCompany.getCreditCode());
		company.setEmployeeNum(eventCompany.getEmployeeNum());
		company.setLastEditTime(new Date());
		company.setLegalIdcard(eventCompany.getLegalIdcard());
		company.setLegalPerson(eventCompany.getLegalPerson());
		company.setLegalPhone(eventCompany.getLegalPhone());
		company.setName(eventCompany.getName());
		company.setRemark(eventCompany.getRemark());
		company.setTopManagerPhone(eventCompany.getTopManagerPhone());
		company.setTopManagerName(eventCompany.getTopManagerName());
		companyMapper.insertSelective(company);
		eventCompany.setCompanyId(company.getId());
    }
    private void updatCompany(EventCompany eventCompany) {
    	Company company=new Company();
    	company.setId(eventCompany.getCompanyId());
		company.setAddress(eventCompany.getAddress());
		company.setAttention(eventCompany.getAttention());
		company.setAttentionRank(eventCompany.getAttentionRank());
		company.setCompanyType(eventCompany.getCompanyType());
		company.setCreateTime(new Date());
		company.setCreditCode(eventCompany.getCreditCode());
		company.setEmployeeNum(eventCompany.getEmployeeNum());
		company.setLastEditTime(new Date());
		company.setLegalIdcard(eventCompany.getLegalIdcard());
		company.setLegalPerson(eventCompany.getLegalPerson());
		company.setLegalPhone(eventCompany.getLegalPhone());
		company.setName(eventCompany.getName());
		company.setRemark(eventCompany.getRemark());
		company.setTopManagerPhone(eventCompany.getTopManagerPhone());
		company.setTopManagerName(eventCompany.getTopManagerName());
		int num=companyMapper.updateByPrimaryKeySelective(company);
		if(num<0) {
			throw new RuntimeException();
		}
		eventCompany.setCompanyId(company.getId());
    }

}
