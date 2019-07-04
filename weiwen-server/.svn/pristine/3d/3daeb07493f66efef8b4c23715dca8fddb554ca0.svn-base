package com.cetc.weiwen.service;

import java.util.Map;

import com.cetc.weiwen.entity.Civics;

public interface CivicsService {

	/**
	 * 根据idcard进行删除
	 * @param idcard
	 * @return
	 */
    int deleteCivicsById(String idcard);

    /**
     * 新增公民信息
     * @param record
     * @return
     */
    int insertCivics(Civics civics);

    /**
     * 新增公民信息，存在判断语句
     * @param civics
     * @return
     */
    int insertPartCivics(Civics civics);

    /**
     * 根据idcard进行查询
     * @param idcard
     * @return
     */
    Civics selectByIdcard(String idcard);

    /**
     * 更新部分信息，存在判断语句
     * @param record
     * @return
     */
    int updatePartCivicsByIdcard(Civics civics);

    /**
     * 更新公民信息
     * @param civics
     * @return
     */
    int updateCivicsByIdcard(Civics civics);
    
    /**根据事件id分页查询涉事人员信息
	 * 
	 * @param id
	 * @param num
	 * @param size
	 * @return
	 */
    Map<String,Object> queryCivicsListByEventId(Integer id, Integer num, Integer size);

    /**
     * 获取公民信息（公民基本信息，信访记录）
     * @param idcard
     * @return
     */
	Map<String, Object> getCivicsDetail(String idcard);

	
    
}
