package com.netease.storedemo.sys.service.impl;

import com.netease.storedemo.sys.domain.User;
import com.netease.storedemo.sys.domain.UserExample;
import com.netease.storedemo.sys.mapper.UserMapper;
import com.netease.storedemo.sys.service.IUserService;
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
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String login(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()!=0 && users.get(0).getPassword().equals(password)){
            if (users.get(0).getType()==1)
                return "buyer";
            else
                return "seller";
        }
        return "fall";
    }
}
