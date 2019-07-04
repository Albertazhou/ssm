package com.cetc.weiwen.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cetc.weiwen.commons.utils.RedisGetUser;
import com.cetc.weiwen.entity.Media;
import com.cetc.weiwen.entity.User;
import com.cetc.weiwen.result.Result;
import com.cetc.weiwen.service.FastDFSClientWrapper;
import com.cetc.weiwen.service.MediaService;

/**
 * 多媒体控制层
 * @author jhl
 * @date 2018年8月3日 下午5:37:31
 * @version 1.0 
 *
 */
@RestController
@RequestMapping(value="/media")
public class MediaController {
	
	@Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
	
	@Autowired
	private MediaService mediaService;

	/**
	 * 上传图片
	 * @param file
	 * @return
	 * @throws IOException
	 */
    @PostMapping(produces = { "application/json;charset=UTF-8" })
    public Result<Media> uploadFile(
    		@RequestParam(name="file",required=true)MultipartFile file,@RequestHeader(value="token")String requestToken) throws IOException {
    	User user= RedisGetUser.getUserByRedis(requestToken);
    	Media media=mediaService.saveMedia(file,1);
        if(media != null) {
        	return Result.success(media);
        }else {
        	return Result.errorMsg("上传图片失败！");
        }
    }
    
	/**
	 * 下载图片
	 * @param fileUrl
	 * @param response
	 * @throws IOException
	 */
    @GetMapping(produces = { "application/json;charset=UTF-8" })
    public void downloadFile(@RequestParam(name="fileUrl",required=true)String fileUrl, 
    			HttpServletResponse response) throws IOException {
        byte[] bytes = fastDFSClientWrapper.downloadFile(fileUrl);
        // 这里只是为了整合fastdfs，所以写死了文件格式。需要在上传的时候保存文件名。下载的时候使用对应的格式
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(UUID.randomUUID().toString()+".jpg", "UTF-8"));
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
	/**
	 * 删除图片
	 * @param fileUrl
	 * @return
	 */
    @DeleteMapping(value="/{id}",produces= {"application/json;charset=UTF-8"})
    public Result<String> deleteFile(@RequestParam(name="id",required=true)Integer mediaId){
    	int code=mediaService.deleteMedia(mediaId);
    	if(code> 0) {
        	return Result.errorMsg("删除失败！");
    	}
    	return Result.success("删除文件成功");
    }
	
	/**
	 * 批量上传多媒体信息
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value="/list", produces = { "application/json;charset=UTF-8" })
	public Result<Object> uploadFileList(MultipartFile[] file)throws IOException{
		List<String> strList = new ArrayList<>();
		for(int i=0; i < file.length; i++) {
			byte[] bytes = file[i].getBytes();
			String originalFileName = file[i].getOriginalFilename();
			String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			String fileName = file[i].getName();
			long fileSize = file[i].getSize();
			System.out.println(originalFileName + "==========" + fileName + "===========" + fileSize + "===============" + extension + "====" + bytes.length);
			String fullStrAddr = fastDFSClientWrapper.uploadFile(bytes, fileSize, extension);
			System.out.println("===================成功=============");
			if(fullStrAddr != null) {
				strList.add(fullStrAddr);
			}
		}
		if(strList.size() == file.length) {
			return Result.success(strList);
		}else {
		  	return Result.errorMsg("上传图片失败！");
		}
	}
}
