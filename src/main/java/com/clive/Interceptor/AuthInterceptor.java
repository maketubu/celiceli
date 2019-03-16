package com.clive.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆判断拦截器
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception{
        //判断用户是否未登陆却访问了需登陆授权的网页
        String userName = (String)request.getSession().getAttribute("userName");
        if (userName != null){
            return true;
        }
        //如果没有登陆 判断是否需登陆授权
        String addr = "";

        if (request.getQueryString() != null){
            //带参数
            addr = request.getRequestURI()+"?"+request.getQueryString();
        }
        else {
            //不带参数
            addr =request.getQueryString();
        }

        String destUrl = addr.substring(9);
        // jiequ  这个地址是用户想访问的地址
        request.getSession().setAttribute("destUrl",destUrl);

        response.sendRedirect("");
        return false;

    }

}




















