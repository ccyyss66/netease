package com.netease.storedemo.sys.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: cysmbp15
 * @date: 2021/3/25
 * @time: 4:58 下午
 * Copyright (C) 2018 MTDP
 * All rights reserved
 */
@Data
public class BoughtInfo {
    private String goodname;

    private Float price;

    private String description;

    private String abstracts;

    private String pic;

    private Integer isSold;

    private Integer orderId;

    private Integer goodid;

    private Date time;

    private Integer number;

    private Float boughtprice;
}
