package com.cetc.weiwen.entity;

import java.util.Date;

public class ProsecuteCivics {
    private Integer prosecuteId;

    private Integer civicsId;

    private String illegalItems;

    private Integer punitiveMeasures;

    private Date createTime;

    public Integer getProsecuteId() {
        return prosecuteId;
    }

    public void setProsecuteId(Integer prosecuteId) {
        this.prosecuteId = prosecuteId;
    }

    public Integer getCivicsId() {
        return civicsId;
    }

    public void setCivicsId(Integer civicsId) {
        this.civicsId = civicsId;
    }

    public String getIllegalItems() {
        return illegalItems;
    }

    public void setIllegalItems(String illegalItems) {
        this.illegalItems = illegalItems == null ? null : illegalItems.trim();
    }

    public Integer getPunitiveMeasures() {
        return punitiveMeasures;
    }

    public void setPunitiveMeasures(Integer punitiveMeasures) {
        this.punitiveMeasures = punitiveMeasures;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}