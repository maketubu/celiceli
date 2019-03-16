package com.clive.controller;

import com.clive.bean.ArticleReplyEntity;
import com.clive.bean.User;
import com.clive.bean.VideoMessageEntity;
import com.clive.service.VideoService;
import com.clive.service.impl.ArticleServiceImpl;
import com.clive.service.impl.LoginServiceImpl;
import com.clive.service.impl.UserInfoServiceImpl;
import com.clive.service.impl.VideoServiceImpl;
import com.clive.tool.GetDataTime;
import com.clive.tool.GetUUID;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MessageRequestController {

    @Autowired
    LoginServiceImpl loginService;
    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    VideoServiceImpl videoService;

    /**
     *  异步ajax实现  视频留言服务
     */
    @RequestMapping(value = "videoMessageService", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void LiuYan(String message, HttpServletRequest request,
                                     HttpServletResponse response, String videoID) throws IOException {
       //获取登陆用户名
        String userName = (String)request.getSession().getAttribute("userName");
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        // 获取打印流
        PrintWriter out = response.getWriter();
        //定义提示类容
        String prompt = "";
        //json与json转换类库
        Gson gson = new Gson();

        if (userName != null){
            // 随机生成一个用户的留言表id
            String messageID = GetUUID.getUUID();
            // 获得当前时间
            String dataTime = GetDataTime.DQtime();
            //获取用户信息
            User user = userInfoService.searchUserByName(userName);
            String userID = user.getUserID();
            String userHeadPic = user.getUserHeadPic();

            //留言内容过滤
            message = message.replaceAll("<[^<]+>//s*|/t|/r|/n|&nbsp;", "");
            //留言内容不能超过150个字
            if (message.length() < 150){
                // 创建留言类实体
                VideoMessageEntity videoMessageEntity = new VideoMessageEntity();
                videoMessageEntity.setMessageContent(message); //内容
                videoMessageEntity.setMessageTime(dataTime); //发表时间
                videoMessageEntity.setMessageHeadPic(userHeadPic); //头像
                videoMessageEntity.setMessageUserName(userName); // 发表人
                videoMessageEntity.setMessageUserID(userID);
                videoMessageEntity.setMessageVideoID(videoID); //视频id
                videoMessageEntity.setMessageID(messageID); //留言id

                // 保存留言
                boolean result = videoService.saveMessage(videoMessageEntity);
                if (result){
                    prompt = "留言成功！";
                }
                else {
                    prompt = "留言失败";
                }
            }
            else {
                prompt = "留言过长！";
            }

        }
        else {
            prompt = "请先登陆！";
        }

        // 将提示注入到html中
        String t1 = gson.toJson(prompt);
        out.write(t1);

    }
}

























