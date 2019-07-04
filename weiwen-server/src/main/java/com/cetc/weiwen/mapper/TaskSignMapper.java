package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.TaskSign;
import com.cetc.weiwen.vo.TaskSignVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskSignMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TaskSign record);

    int insertSelective(TaskSign record);

    TaskSign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskSign record);

    int updateByPrimaryKey(TaskSign record);

    /**
     * 获取签到信息列表
     * @param taskSign
     * @return
     */
	List<TaskSignVo> getTaskSignVoList(TaskSign taskSign);
}