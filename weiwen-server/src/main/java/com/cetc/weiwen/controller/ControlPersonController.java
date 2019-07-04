package com.cetc.weiwen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.ControlPerson;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.ControlPersonService;

/**
 * 重点人控制层
 * @author jhl
 * @date 2018年9月3日 下午5:31:33
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/controlperson")
public class ControlPersonController {

//	@Autowired
//	private ControlPersonService controlPersonService;
//	
	/**
	 * 获取重点人列表
	 * @param regionalName
	 * @param townName
	 * @param civicsName
	 * @return
	 
	@GetMapping(produces= {"application/json;charset=UTF-8"})
	public Result<Object> getControlPersonList(
			@RequestParam(name="regionalCode",required=false)String regionalCode,
			@RequestParam(name="townCode",required=false)String townCode,
			@RequestParam(name="civicsName",required=false)String civicsName,
			@RequestParam(name="status",required=false)Integer status){
		List<Map<String,Object>> mapList = controlPersonService.queryControlPersonList(
				regionalCode, townCode,civicsName,status);
		if(mapList.size() > 0) {
			return Result.success(mapList);
		}else {
			return Result.errorMsg("没有重点人信息！");
		}
	}
	*/
	
	/**
	 * 获取重点人信息
	 * @param id
	 * @param status
	 * @return
	 
	@GetMapping(value="/info", produces= {"application/json;charset=UTF-8"})
	public Result<Object> getControlPersonDetail(
			@RequestParam(name="id",required=true)Integer id){
		Map<String,Object> map = controlPersonService.queryCivicsDetail(id);
		if(map != null) {
			return Result.success(map);
		}else {
			return Result.errorMsg("没有该重点人详细信息！");
		}
	}
	*/
	
	/**
	 * 删除重点人信息
	 * @param id
	 * @return
	 
	@DeleteMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> deleteControlPerson(
			@RequestParam(name="id",required=true)Integer id){
		int num = controlPersonService.deleteControlPerson(id);
		if(num > 0) {
			return Result.success("删除成功！");
		}else {
			return Result.errorMsg("删除失败！");
		}
	}
	*/
	
	/**
	 * 新增重点人信息
	 * @param controlPerson
	 * @return
	
	@PostMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> insertControlPerson(
			@RequestBody ControlPerson controlPerson){
		int num = controlPersonService.insertControlPerson(controlPerson);
		if(num > 0) {
			return Result.success("新增重点人成功！");
		}else {
			return Result.success("新增重点人失败！");
		}
	}
	 */
	
	/**
	 * 更新重点人
	 * @param controlPerson
	 * @return
	 
	@PutMapping(produces= {"application/json;charset=UTF-8"})
	public Result<String> updateControlPerson(
			@RequestBody ControlPerson controlPerson){
		int num = controlPersonService.updateControlPerson(controlPerson);
		if(num > 0) {
			return Result.success("更新重点人信息成功！");
		}else {
			return Result.success("更新重点人信息失败！");
		}
	}
	*/
}
