package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Education;
import com.cetc.weiwen.vo.EducationVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EducationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Education record);

    int insertSelective(Education record);

    Education selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);

    /**
     * 获取法制教育列表
     * @param education
     * @return
     */
	List<EducationVo> getEducationVoList(Education education);
}