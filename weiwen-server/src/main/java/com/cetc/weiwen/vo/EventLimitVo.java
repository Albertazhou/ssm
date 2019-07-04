package com.cetc.weiwen.vo;

import java.util.Date;

public class EventLimitVo {

	private Integer id;

    private String phase;

    private String name;

    private Date date;

    private String place;

    private String outline;
    
    private Integer userId;
    
	private EventLevelContrastVo eventLevelContrastVo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.place = place;
	}

	public String getOutline() {
		return outline;
	}

	public void setOutline(String outline) {
		this.outline = outline;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public EventLevelContrastVo getEventLevelContrastVo() {
		return eventLevelContrastVo;
	}

	public void setEventLevelContrastVo(EventLevelContrastVo eventLevelContrastVo) {
		this.eventLevelContrastVo = eventLevelContrastVo;
	}
	
}
