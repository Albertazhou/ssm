package com.cetc.weiwen.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.RequestLogger;

@Mapper
public interface RequestLoggerMapper {

	/**
	 * 删除请求日志
	 * @param id
	 * @return
	 */
    int deleteRequestLogger(Integer id);

    /**
     * 插入请求日志	
     * @param requestLogger
     * @return
     */
    int insertRequestLogger(RequestLogger requestLogger);

    /**
     * 根据id获取请求日志
     * @param id
     * @return
     */
    RequestLogger queryRequestLoggerById(Integer id);

    /**
     * 更新请求日志
     * @param requestLogger
     * @return
     */
    int updateRequestLogger(RequestLogger requestLogger);

}