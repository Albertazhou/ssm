package com.cetc.weiwen.vo;

import java.util.Date;

import com.cetc.weiwen.entity.Civics;

public class ControlPersonVo {

	private Integer id;

    private Civics civics;

    private Integer contradictionCategory;

    private Integer personLevel;

    private Integer property;

    private Integer pedigree;

    private Integer grade;

    private Integer source;

    private Integer status;

    private String remark;

    private Integer userId;

    private Date createTime;

    private Date lastEditTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Civics getCivics() {
		return civics;
	}

	public void setCivics(Civics civics) {
		this.civics = civics;
	}

	public Integer getContradictionCategory() {
		return contradictionCategory;
	}

	public void setContradictionCategory(Integer contradictionCategory) {
		this.contradictionCategory = contradictionCategory;
	}

	public Integer getPersonLevel() {
		return personLevel;
	}

	public void setPersonLevel(Integer personLevel) {
		this.personLevel = personLevel;
	}

	public Integer getProperty() {
		return property;
	}

	public void setProperty(Integer property) {
		this.property = property;
	}

	public Integer getPedigree() {
		return pedigree;
	}

	public void setPedigree(Integer pedigree) {
		this.pedigree = pedigree;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
    
    
}
