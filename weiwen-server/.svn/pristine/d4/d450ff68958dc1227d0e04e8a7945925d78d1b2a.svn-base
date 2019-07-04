package com.cetc.weiwen.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cetc.weiwen.entity.Media;

public interface MediaService {

	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
    int deleteById(Integer id);

    /**
     * 插入多媒体信息
     * @param media
     * @return
     */
    int insertMedia(Media media);

    /**
     * 插入部分多媒体信息(含有判断语句)
     * @param media
     * @return
     */
    Media saveMedia(MultipartFile file,Integer userId) throws IOException;


    /**
     * 根据id查询多媒体信息
     * @param id
     * @return
     */
    Media queryMediaById(Integer id);

    /**
     * 更新多媒体信息
     * @param media
     * @return
     */
    int updateMedia(Media media);
    
    /**
     * 批量添加多媒体信息
     * @param mediaList
     * @return
     */
    int batchInsertMedia(List<Media> mediaList,int eventId);
    
    /**
     * 根据多媒体信息获取多媒体列表信息
     * @param eventId
     * @return
     */
    List<Media> queryMediaListByMedia(Media media);
    
    /**
     * 根据多媒体信息删除多媒体信息
     * @param media
     * @return
     */
    int deleteMediaByMedia(Media media);
    /**
     * 删除多媒体文件
     * @param mediaId
     * @return
     */
	int deleteMedia(Integer mediaId);
}
