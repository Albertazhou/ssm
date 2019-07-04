package com.cetc.weiwen.entity;

public class Position {
    private Integer id;
    
    private String uuid;
    
    private String name;

    private Integer pOrder;

    public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getPOrder() {
        return pOrder;
    }

    public void setPOrder(Integer pOrder) {
        this.pOrder = pOrder;
    }
}