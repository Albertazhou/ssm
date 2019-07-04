package com.cetc.weiwen.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetc.weiwen.entity.Division;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.DivisionMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.DivisionService;
import com.cetc.weiwen.vo.DivisionLevelVo;

/**
 * 行政区划的业务层
 * @author jhl
 * @date 2018年8月6日 下午3:24:20
 * @version 1.0 
 *
 */
@Service
public class DivisionServiceImpl implements DivisionService {

	protected static final Logger logger = LoggerFactory.getLogger(DivisionServiceImpl.class);
	
	@Autowired
	private DivisionMapper divisionMapper;

	@Override
	public Division queryDivisionByDivision(Division division) {
		Division divi;
		try {
			divi = null;//divisionMapper.queryDivisionByDivision(division);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return divi;
	}
	
	@Override
	public List<DivisionLevelVo> getDivisionList() {
		// TODO Auto-generated method stub
		return null;//divisionMapper.getDivisionList();
	}
	
	/**
	 * 
	 
	@Override
	public Division queryDivisionAndChildren(Division division) {
		Division d = divisionMapper.queryDivisionByDivision(division);
		if(d != null) {
			List<Division> divisionList = divisionMapper.queryDivisionChildList(d.getId());
			if(divisionList.size() > 0) {
				for (Division dTemp : divisionList) {
					Division div = queryDivisionAndChildren(dTemp);
					if(div != null) {
						d.getDivisionList().add(div);
					}
				}
			}
		}
		return d;
	}
	*/

	/* (non-Javadoc)
	 * 根据id判断行政区划是否存在
	 * @see com.cetc.weiwen.service.DivisionService#isExitDivision(java.lang.Integer)
	 */
	@Override
	public boolean isExitDivision(Integer id) {
		// TODO Auto-generated method stub
		if(divisionMapper.selectByPrimaryKey(id)!=null) {
			return true;
		}
		return false;
	}

}
