package com.cetc.weiwen.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Event {
	private Integer id;

    private Integer phase;

    private Integer typeId;

    private Integer numId;

    private Integer levelId;

    private String name;
    
    private Integer chatTotal;
    
    private String newChat;
    

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    private String place;

    private String outline;

    private Double moneyInvolved;

    private String moneyUnit;

    private String mainAppeal;

    private String tooksSteps;

    private Integer status;

    private Double longitude;

    private Double latitude;

    private Date createTime;

    private Date lastEditTime;

    private String remark;
    
    private Integer version;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    public Double getMoneyInvolved() {
        return moneyInvolved;
    }

    public void setMoneyInvolved(Double moneyInvolved) {
        this.moneyInvolved = moneyInvolved;
    }

    public String getMoneyUnit() {
        return moneyUnit;
    }

    public void setMoneyUnit(String moneyUnit) {
        this.moneyUnit = moneyUnit == null ? null : moneyUnit.trim();
    }

    public String getMainAppeal() {
        return mainAppeal;
    }

    public void setMainAppeal(String mainAppeal) {
        this.mainAppeal = mainAppeal == null ? null : mainAppeal.trim();
    }

    public String getTooksSteps() {
        return tooksSteps;
    }

    public void setTooksSteps(String tooksSteps) {
        this.tooksSteps = tooksSteps == null ? null : tooksSteps.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getChatTotal() {
		return chatTotal;
	}

	public void setChatTotal(Integer chatTotal) {
		this.chatTotal = chatTotal;
	}

	public String getNewChat() {
		return newChat;
	}

	public void setNewChat(String newChat) {
		this.newChat = newChat;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
    
	
    
}