package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.ProsecuteCivics;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProsecuteCivicsMapper {
    int insert(ProsecuteCivics record);

    int insertSelective(ProsecuteCivics record);
}