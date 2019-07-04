package com.cetc.weiwen.entity;

import java.util.Date;

public class EventUser {
    private Integer eventId;

    private Integer userId;
    
    private Integer type;

    private Date createTime;
    
    private Long topping; //是否置顶
    
    private Integer readNumber; //已读消息数
    
    private Integer version;//乐观锁

    public Long getTopping() {
		return topping;
	}

	public void setTopping(Long topping) {
		this.topping = topping;
	}

	public Integer getReadNumber() {
		return readNumber;
	}

	public void setReadNumber(Integer readNumber) {
		this.readNumber = readNumber;
	}

	public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    
    public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

    
}