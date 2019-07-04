package com.cetc.weiwen.entity;

import javax.validation.constraints.NotNull;

/**二维码实体类
 * 
 * @author liqiaofei
 * 2018年9月12日
 */
public class QRCode {

	private String code;
	
	private String image;
	
	//二维码宽度
	private Integer width=300;
	//二维码高度
	private Integer height=300;
	//二维码状态0表示失效1表示有效
	private Integer status=1;
	//二维码图片格式 
	private String format="jpg";
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
