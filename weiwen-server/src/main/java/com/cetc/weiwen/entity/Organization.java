package com.cetc.weiwen.entity;

public class Organization {
    private Integer id; //主关键字，自增长
    
    private String puuid; //父uuid

    private String uuid; //	唯一标识

    private String name; //	名称

    private String functionTypeUuid; //部门类型表uuid

    private Integer divisionUcode; //行政区划ucode(关联division)
    
    

    public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFunctionTypeUuid() {
        return functionTypeUuid;
    }

    public void setFunctionTypeUuid(String functionTypeUuid) {
        this.functionTypeUuid = functionTypeUuid == null ? null : functionTypeUuid.trim();
    }

    public Integer getDivisionUcode() {
        return divisionUcode;
    }

    public void setDivisionUcode(Integer divisionUcode) {
        this.divisionUcode = divisionUcode;
    }
}