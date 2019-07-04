package com.cetc.weiwen.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.async.DeferredResult;

import com.cetc.weiwen.entity.QRCode;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;

public interface QRCodeService {

	Result<QRCode> getQRCode(QRCode qrc);

	DeferredResult<Result<User>> asyncGetQRCode(String code);

	Result<String> asyncAuthQRCode(QRCode qrc, HttpServletRequest request);
   
}
