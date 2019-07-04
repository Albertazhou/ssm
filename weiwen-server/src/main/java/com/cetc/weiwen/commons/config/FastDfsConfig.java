package com.cetc.weiwen.commons.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * FastDfs配置类
 * @author jhl
 * @date 2018年8月7日 上午11:05:52
 * @version 1.0 
 *
 */
@Configuration
@ComponentScan(value = "com.github.tobato.fastdfs.service")
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDfsConfig {

}
