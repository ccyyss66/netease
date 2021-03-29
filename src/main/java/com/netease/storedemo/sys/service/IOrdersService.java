package com.netease.storedemo.sys.service;

import com.netease.storedemo.sys.domain.BoughtInfo;
import com.netease.storedemo.sys.domain.Orders;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
public interface IOrdersService{
    public boolean buyAll(List<Orders> orders);
    public List<BoughtInfo> listAll();
}
