package com.clive.controller;


import com.clive.bean.User;
import com.clive.service.impl.LoginServiceImpl;
import com.clive.service.impl.UserInfoServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆前端控制器
 */
@Controller
public class LoginRequestController {
    //注入服务
    @Autowired
    LoginServiceImpl loginServiceImpl;
    @Autowired
    UserInfoServiceImpl userInfoService;

    @RequestMapping("loginService")
    public String loginRequest(String userName, String password, HttpServletRequest request){
        // 1为存在，0为错误
        boolean loginResult = loginServiceImpl.CheckUser(userName, password);
        //检测
        if (loginResult){
            //获取用户信息并将其存取到session中
            User user = userInfoService.searchUserByName(userName);
            request.getSession().setAttribute("userId", user.getUserID());
            request.getSession().setAttribute("userName", userName);
            request.getSession().setAttribute("userHeadPic", user.getUserHeadPic());
            String destUrl = "";
            //判断手否用户想要访问某个地址但是没有登陆
            if(request.getSession().getAttribute("destUrl") != null){
                destUrl = (String) request.getSession().getAttribute("destUrl");
                String kong = "";
                request.getSession().setAttribute("destUrl", kong);
            }
            // 进入用户想要访问的地址
            return "redirect:/"+ destUrl;
        }else {
            request.setAttribute("PHO", "用户名或者密码错误");
        }
        return "login";
    }
}



















