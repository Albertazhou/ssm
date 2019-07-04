package com.cetc.weiwen.exception;

import com.cetc.weiwen.result.CodeMsg;

/**
 * 全局异常类
 * @author liqiaofei
 * 
 */
public class GlobalException extends RuntimeException{

private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public GlobalException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

}
