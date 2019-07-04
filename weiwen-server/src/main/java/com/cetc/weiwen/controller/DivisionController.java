package com.cetc.weiwen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.DivisionService;
import com.cetc.weiwen.vo.DivisionLevelVo;

@RestController
@RequestMapping(value = "/division")
public class DivisionController {
	
//	@Autowired
//	private DivisionService divisionService;
//	
//	@GetMapping(produces = { "application/json;charset=UTF-8" })
//	public Result<List<DivisionLevelVo>> getDivisionList(){
//		return Result.success(divisionService.getDivisionList());
//		
//	}
//	

}
