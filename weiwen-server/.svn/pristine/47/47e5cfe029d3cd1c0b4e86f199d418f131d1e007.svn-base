package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.VisitRecord;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 信访记录
 * @author jhl
 * @date 2018年9月4日 上午11:21:26
 * @version 1.0 
 *
 */
@Mapper
public interface VisitRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(VisitRecord record);

    int insertSelective(VisitRecord record);

    VisitRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VisitRecord record);

    int updateByPrimaryKey(VisitRecord record);
    
    /**
     * 获取信访记录列表
     * @param visitRecord
     * @return
     */
    List<VisitRecord> getVisitRecordList(VisitRecord visitRecord);
}