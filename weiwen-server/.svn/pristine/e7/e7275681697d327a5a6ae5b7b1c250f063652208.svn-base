package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Prosecute;
import com.cetc.weiwen.vo.ProsecuteVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProsecuteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Prosecute record);

    int insertSelective(Prosecute record);

    Prosecute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prosecute record);

    int updateByPrimaryKey(Prosecute record);

    /**
     * 获取依法处置列表
     * @param prosecute
     * @return
     */
	List<ProsecuteVo> getProsecuteVoList(Prosecute prosecute);
}