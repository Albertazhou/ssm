package com.cetc.weiwen.service;

import java.util.List;

import com.cetc.weiwen.entity.Division;
import com.cetc.weiwen.vo.DivisionLevelVo;

/**
 * 行政区划的业务层
 * @author jhl
 * @date 2018年8月6日 下午3:24:20
 * @version 1.0 
 *
 */
public interface DivisionService {

	/**
	 * 根据行政区划获取行政区划信息
	 * @param division
	 * @return
	 */
	Division queryDivisionByDivision(Division division);
	
	//获取行政区划级别列表
    List<DivisionLevelVo> getDivisionList();
    
    /**
     * 查询行政区划和其子集的集合
     * @param division
     * @return
     
    Division queryDivisionAndChildren(Division division);
    */
  
    /**
     * 根据id判断行政区划是否存在
     * @param id
     * @return
     */
    boolean isExitDivision(Integer id); 
}
