package com.cetc.weiwen.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

public class SmsParam {

	@NotNull
	private List<String>  civicsList;
	
	@NotNull
	private Integer eventId;
	
	@NotNull
	private Integer smsType;
	
	private Integer taskId;
    
	public List<String> getCivicsList() {
		return civicsList;
	}

	public void setCivicsList(List<String> civicsList) {
		this.civicsList = civicsList;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getSmsType() {
		return smsType;
	}

	public void setSmsType(Integer smsType) {
		this.smsType = smsType;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	
}
