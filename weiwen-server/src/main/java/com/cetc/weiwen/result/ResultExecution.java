package com.cetc.weiwen.result;

import java.util.List;

public class ResultExecution<T> {

	//状态码
	private int state;
	
	//状态信息
	private String stateInfo;
	
	//返回访客总数
	private long count;
	
	private T t;
	
	private List<T> tList;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public List<T> gettList() {
		return tList;
	}

	public void settList(List<T> tList) {
		this.tList = tList;
	}
	
	//失败返回
	public ResultExecution(){
		
	}
	
	public ResultExecution(ResultEnums enums) {
		this.state = enums.getState();
		this.stateInfo = enums.getStateInfo();
	}
	
	//成功返回
	public ResultExecution(ResultEnums enums,T t) {
		this.state = enums.getState();
		this.stateInfo = enums.getStateInfo();
		this.t = t;
	}
	
	//成功返回
	public ResultExecution(ResultEnums enums,List<T> tList) {
		this.state = enums.getState();
		this.stateInfo = enums.getStateInfo();
		this.tList = tList;
	}
}
