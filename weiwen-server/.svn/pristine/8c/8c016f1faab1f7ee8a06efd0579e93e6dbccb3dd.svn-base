package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Civics;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 公民持久层接口
 * @author jhl
 * @date 2018年8月31日 下午3:18:32
 * @version 1.0 
 *
 */
@Mapper
public interface CivicsMapper {

    int deleteByPrimaryKey(String idcard);

    int insert(Civics record);

    int insertSelective(Civics record);

    /**
     * 根据身份证获取公民信息
     * @param idcard
     * @return
     */
    Civics queryCivicsByIdcard(String idcard);

    int updateByPrimaryKeySelective(Civics record);

    int updateByPrimaryKey(Civics record);
    
    /**
     * 根据用户名户模糊查询公民列表信息
     * @param name
     * @return
     */
    List<Civics> queryCivicsLikeCivics(Civics civics);

    /**
     * 批量获取用信息
     * @param civicsIds
     * @return
     */
	List<Civics> getCivicsList(List<String> civicsIds);
}