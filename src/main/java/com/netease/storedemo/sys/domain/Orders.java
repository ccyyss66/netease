package com.netease.storedemo.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Orders {
    private Integer id;

    private Integer goodid;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Integer number;

    private Float boughtprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getBoughtprice() {
        return boughtprice;
    }

    public void setBoughtprice(Float boughtprice) {
        this.boughtprice = boughtprice;
    }
}