package com.cetc.weiwen.vo;

import java.util.Date;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.User;

public class EventUserVo {

	private User user;
	
	private Event event;
	
	private Integer type;
	
	private Date createTime;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}
