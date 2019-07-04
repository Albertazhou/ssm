package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Task;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    /**
     * 获取任务列表
     * @param task
     * @return
     */
	List<Task> getTaskListByTask(Task task);
}