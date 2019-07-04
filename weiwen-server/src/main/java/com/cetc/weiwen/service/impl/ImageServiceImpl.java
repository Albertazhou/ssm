package com.cetc.weiwen.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.mapper.MediaMapper;
import com.cetc.weiwen.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private MediaMapper mediaMapper;

	@Transactional
	@Override
	public void imagelabeling(String fullStrAddr, Integer type, Integer label,Integer eventId,Integer userId) {
		// TODO Auto-generated method stub
		Media record= new Media();
		record.setCreateTime(new Date());
		record.setGeneralId(eventId);
		record.setUrl(fullStrAddr);
		record.setUserId(userId);
		switch (label) {
		case 2://2表示事件留证
			//将照片追加到现场照片中
			record.setFunType(0);
			record.setType(0);
			mediaMapper.insertSelective(record);
			break;
		case 3://3表示属地带回
			//判断当前用户是否创建属地带回todo
			
			break;
		case 4://4表示统一答复todo
			
			break;
		default:
			//默认是非证据
			
			break;
		}
		
	}

}
