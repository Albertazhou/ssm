package com.cetc.weiwen.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.result.Result;

/**
 * 全局异常请求体统一返回类
 * @author liqiaofei
 * 
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			return Result.error(ex.getCm());
		}else if(e instanceof MethodArgumentTypeMismatchException) {
			return Result.error(CodeMsg.METHOD_ARG_TYPE_EXCEPTION);
		}
		return Result.error(CodeMsg.SERVER_EXCEPTION);
	}
}
