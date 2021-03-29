package com.netease.storedemo.sys.service;

import com.netease.storedemo.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
public interface IUserService {
    public String login(String username,String password);
}
