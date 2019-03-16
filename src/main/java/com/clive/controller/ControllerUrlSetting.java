package com.clive.controller;

import com.clive.Interceptor.Auth;
import com.clive.bean.*;
import com.clive.service.BarrageService;
import com.clive.service.LoginService;
import com.clive.service.PraiseService;
import com.clive.service.PreferenceService;
import com.clive.service.impl.*;
import com.clive.tool.GetDataTime;
import com.clive.tool.GetUUID;
import com.clive.tool.RunUpdateArticleInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该类设置大部分的服务器url, 涉及的服务： 登陆服务， 用户查询服务和增删服务，帖子的查询服务
 */

@Controller
public class ControllerUrlSetting {
    @Autowired
    LoginServiceImpl loginService;

    @Autowired
    UserInfoServiceImpl userInfoService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    VideoInfoServiceImpl videoInfoService;
    @Autowired
    ArticleInfoServiceImpl articleInfoService;
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    PraiseService praiseService;
    @Autowired
    BarrageService barrageService;
    @Autowired
    PreferenceService preferenceService;
    /**
     * 初始化方法
     */
    @PostConstruct
    public void init(){
        System.out.println("初始化项目，只被调用一次！");
    }

    /**
     * 访问首页服务
     */
    @RequestMapping("/index")
    public String toHome(){
        return "forward:/homeVideo.action";
    }

    /**
     *  获取视频推介数据然后返回到首页
     */
    @RequestMapping("/homeVideo")
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response){
        Map model = new HashMap();
        // 获取视频列表
        String userName = (String) request.getSession().getAttribute("userName");
        if(userName!=null){
            String love = preferenceService.getLove(userName);
            ArrayList ary = new ArrayList();
            List<VideoEntity> list = videoInfoService.videoListByType(love); // 动画类型
            for(int i=0;i<6;i++){
                ary.add(list.get(i));
            }
            model.put("listRandom6", ary);
        }else{
            //获取推荐视频列表  这里暂且随机获取六条数据
            List<VideoEntity> listRandom6 = videoInfoService.videoListRandom6MAD();
            model.put("listRandom6", listRandom6);

        }

        List<VideoEntity> listType1 = videoInfoService.videoListByType("1"); // 动画类型
        model.put("listType1",listType1);
        List<VideoEntity> listType2 = videoInfoService.videoListByType("2");
        model.put("listType2",listType2);
        List<VideoEntity> listType3 = videoInfoService.videoListByType("3");
        model.put("listType3",listType3);


        //返回首页
        return new ModelAndView("index", model);

    }

    /**
     *   异步返回视频列表注入到html中
     */

    @RequestMapping(value = "ajaxVideoList1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void ajaxVideoList(HttpServletRequest request,
                                            HttpServletResponse response) throws IOException{
        // 获取推荐视频列表
        List<VideoEntity> list = videoInfoService.videoListRandom7MAD();
        //设置html编码格式
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取html输入流
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String result = gson.toJson(list);
        out.write(result);
    }

    @RequestMapping(value = "ajaxVideoList2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void ajaxVideoList2(HttpServletRequest request,
                                             HttpServletResponse response) throws IOException{
        // 获取推荐视频列表
        List<VideoEntity> list = videoInfoService.videoListRandom5MAD();
        //设置html编码格式
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取html输入流
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String result = gson.toJson(list);
        out.write(result);
    }

    /**
     * 注册服务
     */

    @RequestMapping("register")
    public String register(HttpServletRequest request){
        // 生成验证码
        int num = GetUUID.yanzma();
        String yanzhengma = "";
        yanzhengma = String.valueOf(num);
        //将验证码放入session
        request.getSession().setAttribute("yanzhengma", yanzhengma);
        return "register";
    }

    /**
     * 登陆服务
     */

    @Auth(validate = false)
    @RequestMapping("login.action")
    public String login(){
        return "login";
    }

    /**
     *  用户个人信息修改服务
     */
    @RequestMapping("userInfoModify.action")
    public ModelAndView userInfoModify(HttpServletRequest request){
        // 获取登陆用户
        String userName = (String) request.getSession().getAttribute("userName");
        User user = userInfoService.searchUserByName(userName);
        //传递登陆用户信息，进入信息修改页面
        Map model = new HashMap();
        model.put("user", user);
        // 进入登陆页面
        return  new ModelAndView("userInfoModify", model);
    }

    /**
     *  还有修改个人手机号、密码、邮箱
     */
    @RequestMapping("Update_login_password")
    public String Update_login_password(String password, String newPassword,
                                        String newPassword2, HttpServletRequest request){
        //获取用户信息
        String userName = (String) request.getSession().getAttribute("userName");
        // 判断修改信息的格式
        if (password != null && newPassword2 != null && newPassword != null){
            if (newPassword.equals(newPassword2)){
                // 两次输入的密码相同
                boolean b1 = userService.update_Login_password(userName,password, newPassword);
                if (b1){
                    return "userInformation";
                }else {
                    request.setAttribute("PassWordErro", " 对不起密码输入有误！");
                }
            }
            else {
                request.setAttribute("PassWordErro","两次输入的密码有误");
            }
        }
        return "Update_login_password";
    }

    // 更新邮箱
    @RequestMapping("Update_email")
    public String Update_email(String email, String newEmail, HttpServletRequest request){
        //获取用户信息
        String userName = (String) request.getSession().getAttribute("userName");
        // 判断修改信息的格式
        if (email != null && newEmail != null ){
            boolean b1 = userService.update_Login_Email(userName,email,newEmail);
            if (b1){
                return "userInformation";
            }
            else {
                request.setAttribute("EmailErro", " 对不起邮箱输入有误！");
            }
        }
        else{
            request.setAttribute("PassWordErro","邮箱输入不能未空");
        }
        return "Update_email";
    }

    /**
     * 修改手机界面
     */
    @RequestMapping("Update_Phone")
    public String Update_Phone(HttpServletRequest request, String userPhone, String newUserPhone) {
        // 得到session里面的用户名
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName != null || userPhone != null || newUserPhone != null) {
            boolean b1 = userService.update_Login_Phone(userName, userPhone, newUserPhone);
            if (b1) {
                return "userInformation";
            } else {
                request.setAttribute("PhoneErro", "对不起,原手机号码错误!");
            }
        } else {
            request.setAttribute("PhoneErro", "输入不能为空!");
        }
        return "Update_Phone";// User_full_information.sf

    }




    /**
     * 查看用户所有信息界面服务
     */
    @RequestMapping("userInformation.action")
    public ModelAndView userInformation(HttpServletRequest request){
        // 获取登陆用户
        String userName = (String) request.getSession().getAttribute("userName");
        User user = userInfoService.searchUserByName(userName);
        //传递登陆用户信息，进入信息修改页面
        Map model = new HashMap();
        model.put("user", user);
        // 进入登陆页面
        return  new ModelAndView("userInformation", model);
    }

    /**
     * 修改用户头像服务  修改头像 然后进入用户个人信息修改界面
     */
    @RequestMapping("userHeadPicModify")
    public String userHeadPicModify(HttpServletRequest request){
        // 获取用户信息
        String userName = (String) request.getSession().getAttribute("userName");
        User user = userInfoService.searchUserByName(userName);
        //获取新的头像地址
        String newPic = (String) request.getSession().getAttribute("newHeadPic");
        // 获取旧的头像
        String oldHeadPic = user.getUserHeadPic();
        //替换头像
        boolean result = userService.update_Login_HeadPic(userName, oldHeadPic, newPic);
        if (result){
            System.out.println("成功");
        }
        else {
            System.out.println("失败");
        }
        return "userInfoModify";
    }


    /**
     *  账号切换服务
     */
    @RequestMapping("exchangeUser.action")
    public String exchangeUser(HttpServletRequest request){
        // 消除原用户信息
        request.getSession().removeAttribute("userName");
        //进入登陆界面
        return "login";
    }

    /**
     *   视频展示页服务
     */
    @RequestMapping("videoShow")
    public ModelAndView videoShow(String addr, HttpServletRequest request, String videoID, Model modelBarrages){
        //点赞数量
        int praiseNum=0;
        //根据视频id获取点赞数量
        praiseNum=videoInfoService.selectPraiseNum(videoID);
        //设置点赞数
        request.getSession().setAttribute("praiseNum", praiseNum);
        //得到用户名
        String userName = (String) request.getSession().getAttribute("userName");
        //将string 型的videoId强转为int型
        int lookId=0;
        //判断是否为 vip
        int vipflag = 0;
        /**
         * test4:默认为普通用户
         */
        if(userName!= null) {
            vipflag = videoInfoService.selectVip(videoID, userName);

        }else {
            vipflag = videoInfoService.selectVip(videoID, "test4");
        }
        try {

            lookId = Integer.parseInt(videoID);

        } catch (NumberFormatException e) {

            e.printStackTrace();

        }
        //根据用户名和视频id查询是否有该用户的点赞记录
        int praiseRecord = praiseService.SelectPraiseRecord(lookId,userName);
        //设置点赞记录，0为五，1为有
        request.getSession().setAttribute("praiseRecord", praiseRecord);
        // 设置视频地址
        request.setAttribute("videoAddr", addr);
        // 设置视频id
        request.setAttribute("videoID", videoID);
        //更新视频的浏览次数，每次增加一的浏览量
        videoInfoService.updataVideoLookTime(videoID);
        //点击视频即记录用户偏好
        if (userName!=null){
            /**
             * 根据id寻找视频类型
             * 进行偏好更新
             */
            int videoType = videoInfoService.selectVideoType(videoID);
            preferenceService.updatePreference(userName,videoType );
        }
        //查询关于该视频的所有留言
        List<VideoMessageEntity> messageList = videoInfoService.MessageListByVId(videoID);
        // 返回该列表
        Map model = new HashMap();


        //根据id取出所有弹幕
        List<Barrage> barrages = barrageService.selectAllBarrageByVideoId(lookId);
        model.put("messageList",messageList);
        modelBarrages.addAttribute("barragesList",barrages);
        if(vipflag == 0){
            return new ModelAndView("vip");
        }
        return new ModelAndView("videoShow", model);
    }

    /**
     *  进入 投稿页面 即视频上传页面
     */
    @RequestMapping("videoFileTop")
    public String videoFileTop(HttpServletRequest request){
        return "videoFileTop";
    }

    /**
     * 视频流上传额服务  @RequestParam 快速绑定url参数
     */
    @RequestMapping("videoFileUp")
    public String videoFileUp(@RequestParam("files") MultipartFile[] files ,HttpServletRequest request,
                              String title, String description){
        System.out.println("用户输入的标题为： " + title + description);
        return null;
    }




    /**
     *  论坛首页 即论坛分类页
     */
    @RequestMapping("articleIndex")
    public String articleShow(HttpServletRequest request){
        // 展示 用户总数、帖子总数、今日帖子数、昨天帖子数、7天帖子数
        String userName = (String) request.getSession().getAttribute("getUserName");
        request.setAttribute("userNameMessage", userName);
        request.setAttribute("userCount", RunUpdateArticleInfo.userCount); //用户总数
        request.setAttribute("articleCount", RunUpdateArticleInfo.articleCount); //帖子总数
        request.setAttribute("articleTodayCount", RunUpdateArticleInfo.articleTodayCount); //今日帖子数
        request.setAttribute("articlelastDayCount", RunUpdateArticleInfo.articlelastDayCount); // 昨日帖子数
        request.setAttribute("SevenDayCount", RunUpdateArticleInfo.SevenDayCount);  // 7天内帖子数
        // 进入论坛首页
        return "articleIndex";
    }

    /**
     *  根据论坛类别展示帖子
     */
    @RequestMapping("articleShowAll")
    public ModelAndView articleShowAll(HttpServletRequest request){
        // 获取所有帖子
        List<ArticleEntity> list = articleInfoService.articleListByType("1");
        Map model = new HashMap();
        model.put("article_list", list);
        return new ModelAndView("articleShowAll", model);
    }

    /**
     *  具体帖子页面服务
     *
     */
    @RequestMapping("articlePage")
    public ModelAndView articlePage(HttpServletRequest request, @RequestParam("articleID")String articleID){
        //获取帖子信息
        ArticleEntity article = articleInfoService.articleById(articleID);
        //帖子访问量+1
        article.addPageView();
        String newView = article.getArticlePageView();
        articleService.updatePageView(articleID, newView);
        //根据帖子id 查询所有服务
        List<ArticleReplyEntity> list = articleInfoService.ReplyByArticleId(articleID);
        // 返回该列表
        Map model = new HashMap();
        model.put("article",article);
        model.put("replyList", list);
        return new ModelAndView("articlePage", model);
    }

    /**
     *发表文章 异步实现
     */
    @RequestMapping(value = "articlePublish", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void articleReply(HttpServletRequest request,
                                           HttpServletResponse response,
                                           String title, String content)  throws IOException{
        // 创建一个帖子
        ArticleEntity article = new ArticleEntity();
        article.setArticleID(GetUUID.getUUID()); // id
        article.setArticleTitle(title); //标题
        article.setArticleMessage(content);  //内容
        article.setArticleUserName((String)request.getSession().getAttribute("userName")); //发布人
        article.setArticleTime(GetDataTime.DQtime()); //发布实践
        article.setArticleType("1");  //类别默认
        article.setArticleHeadPic((String)request.getSession().getAttribute("userHeadPic")); //头像
        article.setArticlePageView("0");
        //发表
        boolean result = articleService.saveArticle(article);
        //判断发表结果
        String judge = "";
        if (result){
            judge ="发表成功";
        }
        else {
            judge = "发表失败";
        }
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        // 将结果信息写入html中
        try{
            request.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String temp = gson.toJson(judge);
            out.write(temp);
        }catch (UnsupportedEncodingException e){
            System.out.println("文章发表错误");
        }
    }

    /**
     * 发表帖子回复   异步实现
     */
    @RequestMapping(value = "articleReply", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void articleReply(HttpServletRequest request, String content,String id,
                                           HttpServletResponse response) throws IOException{
        //设置编码
        response.setCharacterEncoding("UTF-8");
        try{
            //创建回复对象
            ArticleReplyEntity reply = new ArticleReplyEntity();
            reply.setReplyHeadPic((String)request.getSession().getAttribute("userHeadPic"));  //头像
            reply.setReplyId(GetUUID.getUUID()); //回复id
            reply.setReplyContent(content); //帖子内容
            reply.setReplyName((String)request.getSession().getAttribute("userName")); //用户名
            reply.setReplyTime(GetDataTime.DQtime()); // 发表时间
            reply.setReplyArticleId(id); // 文章id
            //保存帖子
            String temp = "";
            boolean result = articleService.saveArticleReply(reply);
            if (result){
                temp = "回复成功";
            }
            else{
                temp = "回复失败，请联系管理员！";
            }
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Gson gson  = new Gson();
            String s = gson.toJson(temp);
            out.write(s);
        }catch (UnsupportedEncodingException e){
            System.out.println("回复帖子这里出现错误!");
        }
    }




}































