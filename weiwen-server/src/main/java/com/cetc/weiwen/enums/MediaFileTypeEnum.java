package com.cetc.weiwen.enums;

/**
 * 图片类型枚举类
 * @author jhl
 * @date 2018年7月30日 上午10:14:26
 * @version 1.0 
 *
 */
public enum MediaFileTypeEnum {

	IMG(0,"图片"),VEDIO(1,"视频"),VOICE(2,"声音"),FILE(4,"文档"),OTHER(3,"其他");
	
	private int state;

	private String stateInfo;

	private MediaFileTypeEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public static MediaFileTypeEnum stateOf(int index) {
		for (MediaFileTypeEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
