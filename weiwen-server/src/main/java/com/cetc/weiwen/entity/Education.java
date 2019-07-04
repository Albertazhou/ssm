package com.cetc.weiwen.entity;

import java.util.Date;

public class Education {
    private Integer id;

    private Integer userId;

    private Integer eventId;

    private Integer rankId;

    private Date createTime;

    private Date lastEidtTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEidtTime() {
        return lastEidtTime;
    }

    public void setLastEidtTime(Date lastEidtTime) {
        this.lastEidtTime = lastEidtTime;
    }
}