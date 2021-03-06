package com.cetc.weiwen.vo;

import java.util.Date;

import com.cetc.weiwen.entity.Event;
import com.cetc.weiwen.entity.User;

public class EventCivicsVo {

	private Event event;
	
	private User user;

    private String idcard;

    private String name;

    private String usedName;

    private String nation;

    private String photo;

    private Integer age;

    private String residencePermit;

    private Integer gender;

    private String phone;

    private String address;

    private String domicileAddress;

    private String profession;

    private Integer education;

    private Integer maritalStatus;

    private Integer militaryStatus;

    private String remark;

    private Integer incharge;

    private Date createTime;

    private Date lastEditTime;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsedName() {
		return usedName;
	}

	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getResidencePermit() {
		return residencePermit;
	}

	public void setResidencePermit(String residencePermit) {
		this.residencePermit = residencePermit;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDomicileAddress() {
		return domicileAddress;
	}

	public void setDomicileAddress(String domicileAddress) {
		this.domicileAddress = domicileAddress;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getMilitaryStatus() {
		return militaryStatus;
	}

	public void setMilitaryStatus(Integer militaryStatus) {
		this.militaryStatus = militaryStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIncharge() {
		return incharge;
	}

	public void setIncharge(Integer incharge) {
		this.incharge = incharge;
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
