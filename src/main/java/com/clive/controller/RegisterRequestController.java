package com.clive.controller;

import com.clive.bean.User;
import com.clive.service.PreferenceService;
import com.clive.service.impl.RegisterServiceImpl;
import com.clive.tool.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class RegisterRequestController {

    @Autowired
    RegisterServiceImpl registerService;
    @Autowired
    PreferenceService preferenceService;

    @RequestMapping("registerService")
    public String register(User user, HttpServletRequest request, String yanzheng){
        //设置一个默认的用户id
        user.setUserID(GetUUID.getUUID());
        //设置默认状态
        user.setUserState("正常");
        //设置默认支付密码
        user.setUserPaypassword("123");
        //设置默认头像
        user.setUserHeadPic("/static/userHand_Top/upload/MyHand.png");
        //vip设置
        user.setVip(0);
        //注入偏好设置
        preferenceService.insertUserPreference(user.getUserName());
        // 手机号码 正则表达式
        String phone = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9])|(18[1,5-9])|(17[7,5-9]))\\d{8}$";
        Pattern regex = Pattern.compile(phone);
        Matcher matcher = regex.matcher(user.getUserPhone());
        boolean pho = matcher.matches();  // 判断手机号格式是否匹配
        // 邮箱 正则表达式
        String email = "[a-zA-Z0-9_\\-\\.]+@(sina|qq|163)+(\\.(com|cn|org|edu|hk))";
        Pattern regexemail = Pattern.compile(email);
        Matcher matcheremial = regexemail.matcher(user.getUserEmial());
        boolean emial = matcheremial.matches();  //判断邮箱号格式是否匹配
        //验证用户账号
        String userNmae= "^[a-zA-Z]\\w{5,17}$";
        Pattern regexuserNmae = Pattern.compile(userNmae);
        Matcher matcheruserName = regexuserNmae.matcher(user.getUserName());
        boolean username = matcheruserName.matches();  // 验证账户号格式是否匹配

        //获得验证码.....我是放入到session里的
        String  yan= (String) request.getSession().getAttribute("yanzhengma");
        if(yanzheng.equals(yan)){
            // 验证码匹配
            if (pho) {
                if (emial) {
                    if(username){
                        // 邮箱、手机号、用户名格式没有问题
                        boolean bl = registerService.registerUser(user);
                        if (bl) {
                            // 这里是注册成功
                            request.getSession().setAttribute("getUserName",user.getUserName());
                        } else {
                            request.setAttribute("fail", "注册失败,此用户已经被注册");
                            return "forward:/register.action";
                        }
                    }else{
                        request.setAttribute("fail", "注册失败,用户名输入错误");
                        return "forward:/register.action";
                    }
                } else {
                    request.setAttribute("fail", "注册失败,邮箱地址错误");
                    return "forward:/register.action";
                }
                return "forward:/register.action";

            } else {
                request.setAttribute("fail", "注册失败,手机号码错误");
            }
        }else{
            request.setAttribute("fail", "注册失败,验证码错误");
            return "forward:/register.action";
        }


        return "forward:/login.action";

    }



}










