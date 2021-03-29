package com.netease.storedemo.sys.domain;

import lombok.Data;

/**
 * @description:
 * @author: cysmbp15
 * @date: 2021/3/24
 * @time: 2:57 下午
 * Copyright (C) 2018 MTDP
 * All rights reserved
 */
@Data
public class Response {
    private String status;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
