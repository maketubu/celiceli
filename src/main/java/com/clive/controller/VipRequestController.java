package com.clive.controller;

import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class VipRequestController {
    @Autowired
    UserService userService;

    @RequestMapping("vip")
    public String vip(HttpServletRequest request, @RequestParam("uid") String uid){
        userService.updateVip(uid);
        return "forward:/homeVideo.action";
    }
}
