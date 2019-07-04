package com.cetc.weiwen.commons.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 地址工具类，获取配置文件中的地址信息
 * @author jhl
 * @date 2018年7月27日 下午3:50:32
 * @version 1.0 
 *
 */
@Configuration
public class AddrUtil {

	private static String seperator = System.getProperty("file.separator");

	private static String winPhotoURI;
	
	private static String linuxPhotoURI;
	
	@Value("${win.images.uri}")
	public void setWinPhotoURI(String winPhotoURI) {
		AddrUtil.winPhotoURI = winPhotoURI;
	}

	@Value("${linux.images.uri}")
	public void setLinuxPhotoURI(String linuxPhotoURI) {
		AddrUtil.linuxPhotoURI = linuxPhotoURI;
	}
	
	private static String winVideoURI;
	
	private static String linuxVideoURI;
	
	@Value("${win.video.uri}")
	public void setWinVideoURI(String winVideoURI) {
		AddrUtil.winVideoURI = winVideoURI;
	}

	@Value("${linux.video.uri}")
	public void setLinuxVideoURI(String linuxVideoURI) {
		AddrUtil.linuxVideoURI = linuxVideoURI;
	}
	
	/**
	 * 获取图片文件的绝对路径
	 * @return
	 */
	public static String getImgBasePath(){
		//获取系统名
		String os = System.getProperty("os.name");
		String basePath = "";
		//如若是win系统，则：
		if(os.toLowerCase().startsWith("win")){
			basePath = winPhotoURI;
		}else{
			basePath = linuxPhotoURI;
		}
		//根据不同的系统"/"的方向也不同，所以需要根据系统来替换
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	
	/**
	 * 获取视频文件的绝对路径
	 * @return
	 */
	public static String getVideoBasePath(){
		//获取系统名
		String os = System.getProperty("os.name");
		String basePath = "";
		//如若是win系统，则：
		if(os.toLowerCase().startsWith("win")){
			basePath = winVideoURI;
		}else{
			basePath = linuxVideoURI;
		}
		//根据不同的系统"/"的方向也不同，所以需要根据系统来替换
		basePath = basePath.replace("/", seperator);
		return basePath;
	}


}
