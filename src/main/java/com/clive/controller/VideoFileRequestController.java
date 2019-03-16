package com.clive.controller;

import com.clive.bean.VideoEntity;
import com.clive.mapper.VideoEntityMapper;
import com.clive.service.VideoService;
import com.clive.tool.GetUUID;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoFileRequestController {
    @Autowired
    VideoService videoService;

    /**
     * 文件上传
     * @param request
     */
    @RequestMapping("videpFileUp2")
    public String videpFileTop(HttpServletRequest request
            ,HttpServletResponse response) throws ServletException, IOException {
        try{
            //检测是否支持文件上传
            if (!ServletFileUpload.isMultipartContent(request)){
                throw new RuntimeException("form上传属性非multpart/form-data!");
            }
            /************** 创建工厂 ******************/
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ((DiskFileItemFactory) fileItemFactory).setSizeThreshold(1024 *1024 *2);  //大于2MB则会产生临时文件
            //配置临时文件存放地址
            String temDir = request.getContextPath()+"/static/videolook";
            ((DiskFileItemFactory) fileItemFactory).setRepository(new File(temDir));

            /************** 加载核心类 ******************/
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);  //工厂里的机器 这里是上传机器
            servletFileUpload.setHeaderEncoding("UTF-8");  //设置文件编码格式
            /**************  解析request ******************/
            //解析request， list存放fileItem, 这里一个list表示一个input对象
            List<FileItem> list = servletFileUpload.parseRequest(request);
            //设置监听器 这里还未设置

            //创建video对象
            VideoEntity entity = new VideoEntity();
            entity.setVideoID(GetUUID.getUUID());  //设置id
            entity.setVideoState("1");  //状态默认为1
            entity.setVideoTime("4:00"); // 这里设置默认时长
            entity.setVideolookTime("0"); //设置观察次数
            entity.setVideoType("1");
            entity.setVideoImage("");
            entity.setRecordOfPraise(0);
            entity.setVip(0);

            /************** 遍历获取数据 ******************/
            for (FileItem fileItem :list){
                //首先判断文件是不是普通的表单字段
                if (fileItem.isFormField()){
                    //是普通表单字段  这里存放的是描述信息 即title description
                    String fieldName = fileItem.getFieldName();
                    System.out.println("表单字段为： "+fieldName);
                    //获取表单数据的值，指定编码格式
                    String fieldValue = fileItem.getString("UTF-8");
                    System.out.println(fieldValue);
                    System.out.println();
                    if (fieldName.equals("biaoti")){
                        entity.setVideoName(fieldValue);
                    }
                    if (fieldName.equals("Fruit")){
                        entity.setVideoType((String)fieldValue);
                    }
                }
                else{
                    //如果不是 即使文件元素
                    String fileName = fileItem.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                    //文件重名的情况如何处理
//                    fileName = UUID.randomUUID().toString().replace("-", "")+ fileName;
                    //单个文件夹下文件个数过多怎么办？
                    //打开输入流
                    InputStream is = fileItem.getInputStream();
                    String path = System.getProperty("cilicili.root");
                    String path1 = request.getSession().getServletContext().getRealPath("/");
                    System.out.println("项目的绝对路径："+ path+"/static/videolook");
                    System.out.println("path1:"+path1);
                    System.out.println("地址为： "+ path);
                    System.out.println("文件名为："+fileName);
                    File file = new File(path1+"static\\videolook",fileName);
                    //将request中的输入流输入到指定的文件流里
                    FileUtils.copyInputStreamToFile(is, file);
                    fileItem.delete();

                    // entity对象处理
                    if (fileName.contains("jpg") || fileName.contains("png")){
                        entity.setVideoImage("/static/videolook/"+fileName);
                    }
                    else{
                        entity.setVideoAddress("/static/videolook/"+fileName);
                    }
                }
            }
            //保存视频数据
            videoService.saveVideo(entity);

        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        // 首先检测文件上传的
        return  "videoFileTop";
    }
}
