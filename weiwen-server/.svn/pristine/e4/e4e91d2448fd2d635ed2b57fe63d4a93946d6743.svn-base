package com.cetc.weiwen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetc.weiwen.entity.Company;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.CompanyService;

@RestController
@RequestMapping(value="/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value="/detail",produces= {"application/json;charset=UTF-8"})
	public Result<Object> queryCompanyDetail(
			@RequestParam(name="companyId",required=true)Integer companyId){
		Map<String,Object> map = companyService.queryCompanyDetail(companyId);
		if(map != null) {
			return Result.success(map);
		}else {
			return Result.errorMsg("没有该公司的信息！");
		}
	}
	@PostMapping(produces = {"application/json;charset=UTF-8"})
	public Result<String> insertCompany(@RequestBody Company company){
		
		int effectNum = companyService.insertCompany(company);
		if(effectNum > 0) {
			return Result.success("新增公司成功！");
		}else {
			return Result.errorMsg("新增公司失败！");
		}
		
	}
//	
//	@PutMapping(produces = {"application/json;charset=UTF-8"})
//	public Result<String> updateCompany(@RequestBody Company company){
//		
//		int effectNum = companyService.updateCompanyById(company);
//		if(effectNum > 0) {
//			return Result.success("更新公司成功！");
//		}else {
//			return Result.errorMsg("更新公司失败！");
//		}
//		
//	}
//	
//	@DeleteMapping(value="/{id}",produces = {"application/json;charset=UTF-8"})
//	private Result<String> deleteCompany(
//			@PathVariable(value = "id", required = true) Integer id){
//		int effectNum = companyService.deleteById(id);
//		if(effectNum > 0) {
//			return Result.success("删除公司成功！");
//		}else {
//			return Result.errorMsg("删除公司失败！");
//		}
//	}
//	
//	@GetMapping(value="/{id}",produces = {"application/json;charset=UTF-8"})
//	public Result<Object> getCompany(
//			@PathVariable(value = "id", required = true) Integer id){
//		Company campony = companyService.queryCompanyById(id);
//		if(campony != null) {
//			return Result.success(campony);
//		}else {
//			return Result.error(CodeMsg.FAIL);
//		}
//	}
}
