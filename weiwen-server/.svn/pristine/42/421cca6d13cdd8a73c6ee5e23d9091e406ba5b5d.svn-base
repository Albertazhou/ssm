package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Possession;
import com.cetc.weiwen.vo.PossessionVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PossessionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Possession record);

    int insertSelective(Possession record);

    Possession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Possession record);

    int updateByPrimaryKey(Possession record);

    /**
     * 获取属地带回列表
     * @param possession
     * @return
     */
	List<PossessionVo> getPossessionVoList(Possession possession);
}