package com.cetc.weiwen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cetc.weiwen.commons.interceptor.ClientInterceptor;



/**
 * 程序入口类
 * 
 * @author liqiaofei
 *
 */
@SpringBootApplication
/* 开启事务管理器 */
@EnableTransactionManagement
/* 开启定时任务 */
//@EnableScheduling
public class WeiwenServerApplication extends WebMvcConfigurationSupport   {

	protected static final Logger logger = LoggerFactory.getLogger(WeiwenServerApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("SpringBoot开始加载");
		SpringApplication.run(WeiwenServerApplication.class, args);
		logger.info("SpringBoot加载完毕");
	}
    
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new ClientInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
	
}
