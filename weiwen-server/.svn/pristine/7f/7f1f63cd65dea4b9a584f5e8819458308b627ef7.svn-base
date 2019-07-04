package com.cetc.weiwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.VisitRecord;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.VisitRecordService;

/**
 * 信访记录
 * @author jhl
 * @date 2018年9月7日 下午3:48:54
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/visitrecord")
public class VisitRecordController {

	@Autowired
	private VisitRecordService visitRecordService;
	
	/**
	 * 根据公民身份证获取信访记录
	 * @param idcard
	 * @return
	 */
	@GetMapping(produces= {"application/json;charset=UTF-8"})
	public Result<Object> getVisitRecordList(
			@RequestParam(name="idcard",required=true)String idcard){
		List<VisitRecord> visitRecordsList = visitRecordService.getVisitRecordList(idcard);
		if(visitRecordsList.size() > 0) {
			return Result.success(visitRecordsList);
		}else {
			return Result.errorMsg("没有信访记录！");
		}
	}
}
