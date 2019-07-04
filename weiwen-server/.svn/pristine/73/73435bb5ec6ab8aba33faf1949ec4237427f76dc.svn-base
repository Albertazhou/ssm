package com.cetc.weiwen.commons.interceptor;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cetc.weiwen.commons.constant.Constant;
import com.cetc.weiwen.commons.utils.RedisUtils;
import com.cetc.weiwen.commons.utils.SpringContextHolder;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.CodeMsg;
import com.cetc.weiwen.result.Result;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**客户端视图拦截器
 * 
 * @author liqiaofei
 * 2018年9月6日
 */

public class ClientInterceptor implements HandlerInterceptor{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private ObjectMapper objectMapper=SpringContextHolder.getBean(ObjectMapper.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		
		String basePath = request.getHeader("Origin");
		
		logger.info("param:"+getParams(request.getParameterMap()));
		
		String url=request.getRequestURI();
		//嗅探请求
		if("OPTIONS".equals(request.getMethod())){
 			 return true;
 		}
		String token = request.getHeader("token");
		if(url.startsWith("/weiwen-api/app/login")||url.startsWith("/weiwen-api/web/login")){//系统请求
        	return true;
        }else{
        	if(url.startsWith("/weiwen-api/qrcode")&&!"PUT".equals(request.getMethod())) {return true;}
        	if(StringUtils.isEmpty(token)) {
        		Result<String> ret=Result.error(CodeMsg.TOKEN_NON);
				setErrorResponse(response,ret,basePath);
				return false;
        	}else if(!RedisUtils.exist(token)){
        		Result<String> ret=Result.error(CodeMsg.TOKEN_OVERDUE);
				setErrorResponse(response,ret,basePath);
				return false;
        	}else{
        		//判断是不是app客户端token
        		if(token.startsWith(Constant.USER_TOKEN_APP_PREFIX)) {
        			User user=RedisUtils.get(token,User.class);
        			RedisUtils.expire(token, Constant.USER_CACHE_TIME);
        			RedisUtils.expire(Constant.USER_APP_PREFIX+user.getId(),Constant.USER_CACHE_TIME);
    			//判断是不是web客户端token
        		}else if(token.startsWith(Constant.USER_TOKEN_WEB_PREFIX)) {
        			User user=RedisUtils.get(token,User.class);
        			RedisUtils.expire(token, Constant.USER_CACHE_TIME);
        			RedisUtils.expire(Constant.USER_WEB_PREFIX+user.getId(),Constant.USER_CACHE_TIME);
        		}
        	}
        }
		return true;
	}

	/**
	 * 返回错误信息
	 * @param response
	 * @throws IOException
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 */
	private void setErrorResponse(HttpServletResponse response,Result<String> ret,String basePath)
			throws IOException, JsonGenerationException, JsonMappingException {
		response.setContentType("application/json; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin",basePath);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.getWriter().write(objectMapper.writeValueAsString(ret));
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
//		logger.info(">>>ClientInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
//		logger.info(">>>ClientInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getParams(Map paramMap){
		if (paramMap == null){
			return "";
		}
		StringBuilder params = new StringBuilder();
		for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramMap).entrySet()){
			params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
			String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
			params.append(paramValue);
		}
		return params.toString();
	}
}
