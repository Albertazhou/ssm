package com.cetc.weiwen.result;

public enum ResultEnums {
	
	SUCCESS(200,"成功"),SYS_EXCEPTION(-200,"系统异常"),NULL_INFO(-100,"获取不到参数"),
	INSTER_FAIL(-300,"插入失败！"),DELETE_FAIL(-400,"删除失败！"),UPDATE_FAIL(-500,"更新失败！");

	private int state;

	private String stateInfo;
	
	private ResultEnums(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
	
	public static ResultEnums stateOf(int index) {
		for (ResultEnums state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
