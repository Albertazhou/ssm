package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Media;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MediaMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Media record);

    int insertSelective(Media record);

    Media selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);

    /**
     * 批量添加多媒体信息
     * @param mediaList
     * @return
     */
	int batchInsertMedia(List<Media> mediaList);

	/**
	 * 获取多媒体列表
	 * @param media
	 * @return
	 */
	List<Media> getMediaList(Media media);
	
	/**根据generalId和funType，查询generalId对应的对媒体记录的id列表
	 * 
	 * @param generalId
	 * @param funType
	 * @return
	 */
	List<Media> getMediaListByGeneralIdAndFunType(Integer generalId, Integer funType);
	//根据多媒体ids更新图片的引用状态
	int updateGeneralIdAndFunTypeById(@Param("generalId")Integer generalId,@Param("funType")Integer funType,@Param("ids")List<Integer> ids);

}