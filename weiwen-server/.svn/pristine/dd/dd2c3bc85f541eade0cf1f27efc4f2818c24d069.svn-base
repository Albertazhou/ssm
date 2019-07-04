package com.cetc.weiwen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.cetc.weiwen.entity.QRCode;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.QRCodeService;

/**
 * 二维码相关控制器
 * 
 * @author liqiaofei 2018年9月11日
 */
@RestController
@RequestMapping(value = "/qrcode")
public class QRCodeController {

	@Autowired
	private QRCodeService qRCodeService;
	
	/**
	 * 获取base64字符串二维码数据 code参数产生二维码 w设置二维码的宽度 h设置二维码的高度
	 * 
	 * @return
	 */
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	public Result<QRCode> getQRCode(@RequestBody QRCode qrc) {
		return qRCodeService.getQRCode(qrc);
	}

	/**
	 *  异步处理二维码登录接口
	 * 
	 * @return
	 */
	@GetMapping(produces = { "application/json;charset=UTF-8" })
	public DeferredResult<Result<User>>  asyncGetQRCode(String code) {
		return qRCodeService.asyncGetQRCode(code);
	}
	
	/**异步处理认证二维码
	 * 
	 * @param qrc
	 * @param request
	 * @return
	 */
	@PutMapping(produces = { "application/json;charset=UTF-8" })
	public Result<String> asyncAuthQRCode(@Validated @RequestBody QRCode qrc,HttpServletRequest request) {
		return qRCodeService.asyncAuthQRCode(qrc,request);
	}
	
}
