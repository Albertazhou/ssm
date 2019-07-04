package com.cetc.weiwen.vo;

import com.cetc.weiwen.entity.Event;

/*首页数据*/
public class EventVo extends Event {

	private Long top;
	
	private Integer level;
	
	private Integer noReadCount;

	public Long getTop() {
		return top;
	}

	public void setTop(Long top) {
		this.top = top;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getNoReadCount() {
		return noReadCount;
	}

	public void setNoReadCount(Integer noReadCount) {
		this.noReadCount = noReadCount;
	}
	
	
}
