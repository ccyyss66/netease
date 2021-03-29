package com.netease.storedemo.sys.service.impl;

import com.netease.storedemo.sys.domain.Good;
import com.netease.storedemo.sys.domain.GoodExample;
import com.netease.storedemo.sys.domain.Response;
import com.netease.storedemo.sys.mapper.GoodMapper;
import com.netease.storedemo.sys.service.IGoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Override
    public boolean addOne(Good good) {
        good.setIsSold(0);
        if (good.getId()==null) {
            if (goodMapper.insert(good) > 0) {
                return true;
            } else return false;
        }else{
            if (goodMapper.updateByPrimaryKey(good)>0){
                return true;
            }
            else return false;
        }
    }

    @Override
    public List<Good> getList() {
        GoodExample goodExample = new GoodExample();
        List<Good> goods = goodMapper.selectByExample(goodExample);
        return goods;
    }

    @Override
    public Response delOne(int id) {
        Response response = new Response();
        Good good = goodMapper.selectByPrimaryKey(id);
        if (good!=null){
            if (good.getIsSold()==0) {
                goodMapper.deleteByPrimaryKey(id);
                response.setStatus("200");
                response.setMsg("删除成功");
            }else{
                response.setStatus("500");
                response.setMsg("商品已售出");
            }
        }else{
            response.setStatus("500");
            response.setMsg("无该商品");
        }
        return response;
    }

    @Override
    public Good getOne(int id) {
        Good good = goodMapper.selectByPrimaryKey(id);
        return good;
    }

}
