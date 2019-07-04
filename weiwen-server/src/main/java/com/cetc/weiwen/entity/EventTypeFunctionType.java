package com.cetc.weiwen.entity;

public class EventTypeFunctionType {
    private Integer id;

    private String uuid;

    private String eventTypeUuid;

    private String eventTypeName;

    private String functionTypeUuid;

    private String functionTypeName;

    private Integer divisionLevel;

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

    public String getEventTypeUuid() {
        return eventTypeUuid;
    }

    public void setEventTypeUuid(String eventTypeUuid) {
        this.eventTypeUuid = eventTypeUuid == null ? null : eventTypeUuid.trim();
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName == null ? null : eventTypeName.trim();
    }

    public String getFunctionTypeUuid() {
        return functionTypeUuid;
    }

    public void setFunctionTypeUuid(String functionTypeUuid) {
        this.functionTypeUuid = functionTypeUuid == null ? null : functionTypeUuid.trim();
    }

    public String getFunctionTypeName() {
        return functionTypeName;
    }

    public void setFunctionTypeName(String functionTypeName) {
        this.functionTypeName = functionTypeName == null ? null : functionTypeName.trim();
    }

    public Integer getDivisionLevel() {
        return divisionLevel;
    }

    public void setDivisionLevel(Integer divisionLevel) {
        this.divisionLevel = divisionLevel;
    }
}