package com.cetc.weiwen.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.commons.async.DeferredResultHolder;
import com.cetc.weiwen.commons.constant.Constant;
import com.cetc.weiwen.commons.qrcode.QRCodeFactory;
import com.cetc.weiwen.commons.utils.IdGen;
import com.cetc.weiwen.commons.utils.MD5Util;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.entity.QRCode;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	@Autowired
	private DeferredResultHolder<User> deferredResultHolder;
	
	@Override
	public Result<QRCode> getQRCode(QRCode qrc) {
		// TODO Auto-generated method stub
		String code=Constant.QRCODE+MD5Util.MD5(IdGen.uuid());
		qrc.setCode(code);
		// 根据随机数生成二维码
		String qrcode = QRCodeFactory.imgToBase64Str(qrc.getCode(), qrc.getFormat(), qrc.getWidth(), qrc.getHeight());
		if (qrcode == null) {
			return Result.errorMsg("二维码生成失败");
		}
		// 设置二维码过期时间
		// QRCODE_+code--->key-->存入redis，value=""
		RedisUtils.set(Constant.QRCODE + qrc.getCode(), "", Constant.QRCODE_CACHE_TIME);
		// 返回二维码
		QRCode data=new QRCode();
		data.setCode(code);
		data.setImage(qrcode);
		return Result.success(data);
	}

	@Override
	public DeferredResult<Result<User>> asyncGetQRCode(String code) {
		
		DeferredResult<Result<User>> result=new DeferredResult<>(60000l,Result.error(CodeMsg.QRCODE_OVERDUE));
		
		deferredResultHolder.getMap().put(code, result);
		
		return result;
	}

	@Override
	public Result<String> asyncAuthQRCode(QRCode qrc, HttpServletRequest request) {
		
		String token = request.getHeader("token");
		if(token.startsWith(Constant.USER_TOKEN_WEB_PREFIX)) {
			return Result.error(CodeMsg.TOKEN_ERROR);
		}
		// 判断随机数在redis中是否已经存在
		if (!RedisUtils.exist(Constant.QRCODE + qrc.getCode())) {
			return Result.error(CodeMsg.QRCODE_OVERDUE);
		}
		DeferredResult<Result<User>> ret=deferredResultHolder.getMap().get(qrc.getCode());
		if (qrc.getStatus().equals(0)) {
			RedisUtils.del(Constant.QRCODE + qrc.getCode());
			ret.setResult(Result.successMsg("退出登录"));
			return Result.success("退出登录");
		}
		String userJson=RedisUtils.get(token,String.class);
		User user = JSON.parseObject(userJson, User.class);
		// 挤掉用户
		if (RedisUtils.exist(Constant.USER_WEB_PREFIX + user.getId())) {
			String oldToken = RedisUtils.get(Constant.USER_WEB_PREFIX + user.getId(),String.class);
			RedisUtils.del(Constant.USER_WEB_PREFIX + user.getId());
			RedisUtils.del(Constant.USER_TOKEN_WEB_PREFIX + oldToken);
		}
		// 返回和缓存用户信息
		String token2 = IdGen.uuid();
		user.setToken(Constant.USER_TOKEN_WEB_PREFIX + token2);
		String userJ=JSON.toJSONString(user);
		RedisUtils.set(Constant.USER_TOKEN_WEB_PREFIX + token2, userJ, Constant.USER_CACHE_TIME);
		RedisUtils.set(Constant.USER_WEB_PREFIX + user.getId(), token2, Constant.USER_CACHE_TIME);
		RedisUtils.del(Constant.QRCODE + qrc.getCode());
		ret.setResult(Result.success(user));
		return Result.success("登录成功");
	}
	
}
