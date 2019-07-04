package com.cetc.weiwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.MediaService;

/**
 * 事件与多媒体联合表的控制层
 * @author jhl
 * @date 2018年8月9日 下午5:17:06
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/eventMedia")
public class EventMediaController {
	
	@Autowired
	private MediaService mediaService;

	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> insertEventMedia(
			@RequestParam(name="mediaList",required=true)String mediaListStr,
			@RequestParam(name="eventId",required=false)Integer eventId){
		List<Media> mediaList = JSON.parseArray(mediaListStr, Media.class);
		if(mediaList.size() < 0) {
			return Result.errorMsg("请传输图片信息！");
		}
		int num = mediaService.batchInsertMedia(mediaList,eventId);
		if(num != mediaList.size()) {
			return Result.errorMsg("未能将全部多媒体信息插入信息表！");
		}
		return Result.success("插入多媒体信息成功！");
	}
}
