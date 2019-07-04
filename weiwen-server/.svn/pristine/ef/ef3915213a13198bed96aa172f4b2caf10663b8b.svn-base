package com.cetc.weiwen.commons.config;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cetc.weiwen.commons.utils.RedisGetUser;
import com.cetc.weiwen.entity.RequestLogger;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.service.RequestLoggerService;

@Aspect
@Component
public class ControllerLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private RequestLoggerService requestLoggerService;
    
    private RequestLogger requestLogger = new RequestLogger();
    
    ThreadLocal<Long> startTime = new ThreadLocal<>();
 
    //这个表达式的意思是，cotroller这个controller下所有的方法都会切入
    @Pointcut("execution(public * com.cetc.weiwen.controller..*.*(..))")
    public void setLogger(){}
 
    @Before("setLogger()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        String url = request.getRequestURL().toString();
        
        String method = request.getMethod();
        String ip = request.getRemoteAddr();
        String user = "";
        //这个地方逻辑有问题
        if(request.getHeader("token") != null) {
        	String token =request.getHeader("token");
            User u = RedisGetUser.getUserByRedis(token);
            user = "用户名：" + u.getUsername() + "，真实姓名：" + u.getRealName() + "，token：" + u.getToken();
        }
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName() + "." 
        		+ joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        
        // 记录下请求内容
        logger.info("请求url : " + url);
        logger.info("请求类型 : " + method);
        logger.info("IP : " + ip);
//        logger.info("请求用户:" + user);
        logger.info("接口包路径 : " + declaringTypeName);
        logger.info("参数 : " + args);
        requestLogger.setArgs(args);
        requestLogger.setCreateTime(new Date());
        requestLogger.setDeclaringTypeName(declaringTypeName);
        requestLogger.setIp(ip);
        requestLogger.setMethod(method);
        requestLogger.setUrl(url);
        requestLogger.setUser(user);
    }
 
    @AfterReturning(returning = "ret", pointcut = "setLogger()")
    public void doAfterReturning(Object ret) throws Throwable {
    	Long time = System.currentTimeMillis() - startTime.get();
        // 处理完请求，返回内容
        logger.info("返回结果 : " + ret);
        logger.info("消耗时间 : " + time);
        requestLogger.setResult(ret.toString());
        requestLogger.setSpendTime(time);
//        try {
//			requestLoggerService.insertRequestLogger(requestLogger);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
    }
	 

}
