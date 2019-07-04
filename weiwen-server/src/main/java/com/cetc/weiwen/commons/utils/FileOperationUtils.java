package com.cetc.weiwen.commons.utils;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.cetc.weiwen.service.FastDFSClientWrapper;

public class FileOperationUtils {
	private static FastDFSClientWrapper fastDFSClientWrapper=SpringContextHolder.getBean(FastDFSClientWrapper.class);
	public static String saveFile(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		byte[] bytes = file.getBytes();
        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = file.getName();
        long fileSize = file.getSize();
        System.out.println(originalFileName + "==========" + fileName + "===========" + fileSize + "===============" + extension + "====" + bytes.length);
        String fullStrAddr = fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
		return fullStrAddr;
	}
}
