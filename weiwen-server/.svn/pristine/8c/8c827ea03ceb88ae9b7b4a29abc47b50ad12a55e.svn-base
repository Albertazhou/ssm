package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.SmsInfo;
import com.cetc.weiwen.vo.SmsInfoVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SmsInfo record);

    int insertSelective(SmsInfo record);

    SmsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsInfo record);

    int updateByPrimaryKey(SmsInfo record);

    /**
     * 获取执法短信列表
     * @param smsInfo
     * @return
     */
	List<SmsInfoVo> getSmsInfoVoList(SmsInfo smsInfo);

	int batchSmsInfo(List<SmsInfo> smsInfoList);
}