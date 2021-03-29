package com.netease.storedemo.sys.controller;


import com.netease.storedemo.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class UserController {

    @Autowired
    IUserService userService;
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(String username,String password,HttpServletRequest request){
        //MD解密
        String s = userService.login(username,password);
        if (s.equals("buyer")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("buyer", "buyer");
            return "buyer";
        }
        else if (s.equals("seller")){
            HttpSession session = request.getSession(true);
            session.setAttribute("seller", "seller");
            return "seller";
        }else
            return "fall";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public boolean logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return true;
    }

}
