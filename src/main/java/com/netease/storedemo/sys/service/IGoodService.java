package com.netease.storedemo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.netease.storedemo.sys.domain.Good;
import com.netease.storedemo.sys.domain.Response;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cys
 * @since 2021-03-22
 */
public interface IGoodService {
    public boolean addOne(Good good);
    public List<Good> getList();
    public Response delOne(int id);
    public Good getOne(int id);
}
