package com.cetc.weiwen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FunctionType {
    private Integer id; //	主键id
    
    private String uuid;//唯一标识符

    private String name;//名称
    
    private Integer type;//部门类型，0：稳控单位，1：职能部门
    
   

    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "FunctionType [id=" + id + ", name=" + name + ", type="  + "]";
	}

   
    
    
}