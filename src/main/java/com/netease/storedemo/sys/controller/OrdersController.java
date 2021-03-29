package com.netease.storedemo.sys.controller;


import com.netease.storedemo.sys.domain.BoughtInfo;
import com.netease.storedemo.sys.domain.Orders;
import com.netease.storedemo.sys.domain.Response;
import com.netease.storedemo.sys.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
@RestController
@CrossOrigin
@RequestMapping("/sys")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;

    /**
     * 功能描述:
     * 清空购物车
     * @Author:cysmbp15
     * @Date: 2021/3/25 7:42 下午
     */
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Response buy(@RequestBody List<Orders> orders){
        Response response =  new Response();
        if (ordersService.buyAll(orders)){
            response.setStatus("200");
            response.setStatus("购买成功");
        }
        else{
            response.setStatus("500");
            response.setStatus("购买失败");
        }
        return response;
    }
    /**
     * 功能描述:
     * 账务
     * @return:
     * @Author:cysmbp15
     * @Date: 2021/3/25 7:44 下午
     */
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<BoughtInfo> boughtInfoList(){
        return ordersService.listAll();
    }



}
