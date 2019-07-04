package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.UnifyReply;
import com.cetc.weiwen.vo.UnifyReplyVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UnifyReplyMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UnifyReply record);

    int insertSelective(UnifyReply record);

    UnifyReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UnifyReply record);

    int updateByPrimaryKey(UnifyReply record);

    /**
     * 获取统一答复列表
     * @param unifyReply
     * @return
     */
	List<UnifyReplyVo> getUnifyReplyVoList(UnifyReply unifyReply);
}