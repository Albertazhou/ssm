package com.cetc.weiwen.enums;

public enum StandardEnum {

	EVENT(10000,"事件"),TASK(20000,"任务"),GROUP(30000,"群通知"),IN_CHARGE(40000,"管控");
	
	int status;
	
	String value;
	
	StandardEnum(int status, String value) {
		this.status = status;
		this.value = value;
	}
	
	public int getStatus() {
		return status;
	}

	public String getValue() {
		return value;
	}

	public static StandardEnum getBystatus(int status) {
		for(StandardEnum typeEnum : StandardEnum.values()) {
			if(typeEnum.status == status) {
				return typeEnum;
			}
		}
		throw new IllegalArgumentException("No element matches " + status);
	}
}
