package com.cetc.weiwen.commons.utils;

import com.cetc.weiwen.enums.MediaFileTypeEnum;

/**
 * 获取文件扩展名工具类
 * @author jhl
 * @date 2018年7月30日 上午9:46:37
 * @version 1.0 
 *
 */
public class FileNameUtil {
	
	/**
     * 获取文件扩展名
     * @return
     */
    public static String extensionName(String filename) {
        int index = filename.lastIndexOf(".");
 
        if (index == -1) {
            return null;
        }
        String result = filename.substring(index + 1);
        return result;
    }
    
    /**
     * 获取文件类型
     * @param filename
     * @return(0:图片、1:视频、2:音频、3:其他、4:文档)
     */
    public static Integer getFileType(String filename) {
    	
    	 int index = filename.lastIndexOf(".");
    	 
         if (index == -1) {
             return null;
         }
         String result = filename.substring(index + 1);
         
         if(handlMusic(result)) {
        	 return MediaFileTypeEnum.VOICE.getState();
         }else if(handleImg(result)) {
        	 return MediaFileTypeEnum.IMG.getState();
         }else if(handlVideo(result)) {
        	 return MediaFileTypeEnum.VEDIO.getState();
         }else if(handlFile(result)){
        	 return MediaFileTypeEnum.FILE.getState();
         }else {
        	 return MediaFileTypeEnum.OTHER.getState();
         }
    }
    
    /**
     * 根据拓展名判断是否是音乐类型
     * @param fileUrl
     * @return
     */
    private static boolean handlMusic(String musicUrl) {

    	// 创建音乐类型数组
    	String music[] = { "mp3", "wma", "wav", "mod", "ra", "cd", "md", "asf", "aac", "vqf", "ape", "mid", "ogg",
    	"m4a", "vqf" };
    	
    	for (int i = 0; i < music.length; i++) {
    		if (music[i].equals(musicUrl)) {
    		return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 根据拓展名判断是否是视频类型
     * @param fileUrl
     * @return
     */
    private static boolean handlVideo(String videoUrl) {
    	// 创建视频类型数组
    	String video[] = { "mp4", "avi", "mov", "wmv", "asf", "navi", "3gp", "mkv", "f4v", "rmvb", "webm" };
    	
    	for (int i = 0; i < video.length; i++) {
    		if (video[i].equals(videoUrl)) {
    		return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 根据拓展名判断是否是文档类型
     * @param fileUrl
     * @return
     */
    private static boolean handlFile(String fileUrl) {
    	// 创建文档类型数组
    	String document[] = { "txt", "doc", "docx", "xls", "htm", "html", "jsp", "rtf", "wpd", "pdf", "ppt" };
    	
    	for (int i = 0; i < document.length; i++) {
    		if (document[i].equals(fileUrl)) {
    		return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 根据拓展名判断是否是图片
     * @param imgUrl
     * @return
     */
    private static boolean handleImg(String imgUrl) {
    	// 创建图片类型数组
    	String img[] = { "bmp", "jpg", "jpeg", "png", "tiff", "gif", "pcx", "tga", "exif", "fpx", "svg", "psd",
    	"cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "wmf" };
    	for (int i = 0; i < img.length; i++) {
    		if (img[i].equals(imgUrl)) {
    		return true;
    		}
    	}
    	return false;
    }
}
