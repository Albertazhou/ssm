package com.cetc.weiwen.entity;

public class ChatContent {

	/*type表示聊天信息类型
	 * 1：表示语音聊天
	 * 2：表示文字聊天
	 * 3：表示图片聊天
	 * 4： 表示文件
	 * 5: 表示视频文件
	 * 6: 页面跳转(跳转到事件详情,事件群里的第一条信息)
	 * */
	private Integer type;
	/*
	 * content表示具体类型对应的内容
	 * */
	private String content;
	/*当type=3
	 * 表示图片标签化，所以
	 *label为1表示非证据
	 *  为2表示事件留证
	 *  为3表示属地带回
	 * 为4表示统一答复
	 * */
	private Integer label;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLabel() {
		return label;
	}

	public void setLabel(Integer label) {
		this.label = label;
	}
	
	
}
