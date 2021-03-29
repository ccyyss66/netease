package com.netease.storedemo.sys.service.impl;

import com.netease.storedemo.sys.domain.*;
import com.netease.storedemo.sys.mapper.GoodMapper;
import com.netease.storedemo.sys.mapper.OrdersMapper;
import com.netease.storedemo.sys.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public boolean buyAll(List<Orders> orderss) {
        int len = orderss.size();
        for (int i=0;i<len;i++){
            try {
                ordersMapper.insert(orderss.get(i));
                Good good = new Good();
                good.setId(orderss.get(i).getGoodid());
                good.setIsSold(1);
                goodMapper.updateByPrimaryKeySelective(good);
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }


    @Override
    public List<BoughtInfo> listAll() {
        OrdersExample ordersExample = new OrdersExample();
        GoodExample goodExample = new GoodExample();
        List<Orders> orders = ordersMapper.selectByExample(ordersExample);
        int len = orders.size();
        List<Integer> listIds = new ArrayList<>();
        HashMap<Integer,Orders> orderMap = new HashMap<>();
        for (int i=0;i<len;i++){
            listIds.add(orders.get(i).getGoodid());
            orderMap.put(orders.get(i).getGoodid(),orders.get(i));
        }
        GoodExample.Criteria criteria = goodExample.createCriteria();
        criteria.andIdIn(listIds);
        List<Good> goods = goodMapper.selectByExample(goodExample);
        HashMap<Integer,Good> goodMap = new HashMap<>();
        List<BoughtInfo> infos = new ArrayList<>();
        for (int i=0;i<len;i++){
            goodMap.put(goods.get(i).getId(),goods.get(i));
        }
        for (int i=0;i<len;i++){
            BoughtInfo boughtInfo = new BoughtInfo();
            int goodId = listIds.get(i);
            Good good = goodMap.get(goodId);
            Orders orders1 = orderMap.get(goodId);
            boughtInfo.setAbstracts(good.getAbstracts());
            boughtInfo.setGoodname(good.getGoodname());
            boughtInfo.setDescription(good.getDescription());
            boughtInfo.setIsSold(good.getIsSold());
            boughtInfo.setPrice(good.getPrice());
            boughtInfo.setBoughtprice(orders1.getBoughtprice());
            boughtInfo.setPic(good.getPic());
            boughtInfo.setTime(orders1.getTime());
            boughtInfo.setNumber(orders1.getNumber());
            boughtInfo.setOrderId(orders1.getId());
            boughtInfo.setGoodid(goodId);
            infos.add(boughtInfo);
        }
        return infos;
    }
}
