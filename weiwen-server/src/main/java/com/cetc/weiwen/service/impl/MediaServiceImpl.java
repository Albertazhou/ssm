package com.cetc.weiwen.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cetc.weiwen.commons.utils.FileNameUtil;
import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.exception.GlobalException;
import com.cetc.weiwen.mapper.MediaMapper;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.service.FastDFSClientWrapper;
import com.cetc.weiwen.service.MediaService;

/**
 * 多媒体业务层实现类
 * @author jhl
 * @date 2018年7月30日 上午9:37:10
 * @version 1.0 
 *
 */
@Service
public class MediaServiceImpl implements MediaService {
	
	protected static final Logger logger = LoggerFactory.getLogger(MediaServiceImpl.class);

	@Autowired
	private MediaMapper mediaMapper;
	
	@Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
	
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;// mediaMapper.deleteById(id);
	}

	@Override
	public int insertMedia(Media media) {
		// TODO Auto-generated method stub
		return 0;// mediaMapper.insertMedia(media);
	}

	@Override
	public Media saveMedia(MultipartFile file,Integer userId) throws IOException {
		// TODO Auto-generated method stub
		byte[] bytes = file.getBytes();
        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = file.getName();
        long fileSize = file.getSize();
        System.out.println(originalFileName + "==========" + fileName + "===========" + fileSize + "===============" + extension + "====" + bytes.length);
        String fullStrAddr = fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
        System.out.println("===================成功=============");
        Media media=new Media();
        media.setCreateTime(new Date());
        media.setFunType(5);
        media.setGeneralId(-1);
        media.setLastEditTime(new Date());
        media.setType(FileNameUtil.getFileType(originalFileName));
        media.setUrl(fullStrAddr);
        media.setUserId(userId);
        int code=mediaMapper.insert(media);
        if(code<=0) {
        	return null;
        }
		return media;
	}

	@Override
	public Media queryMediaById(Integer id) {
		// TODO Auto-generated method stub
		return null;//mediaMapper.queryMediaById(id);
	}

	@Override
	public int updateMedia(Media media) {
		// TODO Auto-generated method stub
		return 0;// mediaMapper.updateMedia(media);
	}

	/**
	 * 批量添加多媒体信息
	 */
	@Override
	@Transactional
	public int batchInsertMedia(List<Media> mediaList,int eventId) {
		for (Media media : mediaList) {
			int type =0;// FileNameUtil.getFileType(media.getUrl());
			//media.setEventId(eventId);
		//	media.setType(String.valueOf(type));
			media.setCreateTime(new Date());
			media.setLastEditTime(new Date());
		}
		int effectNum;
		try {
			effectNum =0;// mediaMapper.batchInsertMedia(mediaList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return effectNum;
	}

	@Override
	public List<Media> queryMediaListByMedia(Media media) {
		List<Media> mediaList;
		try {
			mediaList = null;//mediaMapper.queryMediaListByMedia(media);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
		}
		return mediaList;
	}

	@Override
	public int deleteMediaByMedia(Media media) {
		// TODO Auto-generated method stub
		return 0;// mediaMapper.deleteMediaByMedia(media);
	}

	@Override
	public int deleteMedia(Integer mediaId) {
		// TODO Auto-generated method stub
		Media media=mediaMapper.selectByPrimaryKey(mediaId);
		if(media==null) {
			return 0;
		}
		String fileUrl=media.getUrl();
		//删除fastdfstup
		fastDFSClientWrapper.deleteFile(fileUrl);
		//删除数据库中的数据
		return mediaMapper.deleteByPrimaryKey(mediaId);
	}

	


}
