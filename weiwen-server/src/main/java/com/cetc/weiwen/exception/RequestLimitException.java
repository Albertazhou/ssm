package com.cetc.weiwen.exception;

/**
 * http请求异常
 * @author jhl
 * @date 2018年8月13日 上午9:52:44
 * @version 1.0 
 *
 */
public class RequestLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6360701191899703390L;

	public RequestLimitException() {
		super("HTTP请求超出设定的限制");
	}
	
	public RequestLimitException(String message){
		super(message);
	}
}
