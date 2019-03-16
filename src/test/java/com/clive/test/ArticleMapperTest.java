package com.clive.test;
import com.clive.bean.ArticleEntity;
import com.clive.bean.Items;
import com.clive.service.ArticleInfoService;
import com.clive.service.ArticleService;
import com.clive.service.ItemService;
import com.clive.service.impl.ArticleServiceImpl;
import com.clive.tool.GetUUID;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ArticleMapperTest {
    ApplicationContext ac;

    @Before
    public void initTest(){
        ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    // 测试mybatis
    @Test
    public void test1(){
        ArticleInfoService articleService = (ArticleInfoService)ac.getBean("articleInfoServiceImpl");
        String id = "54e3aeb9feb047138ae2fa1783f242c8";
        ArticleEntity entity = articleService.articleById(id);
        System.out.println(entity);
    }
    @Test
    public void test2(){
        ArticleInfoService articleService = (ArticleInfoService)ac.getBean("articleInfoServiceImpl");
        String type = "1";
        List<ArticleEntity> list = articleService.articleListByType(type);
        System.out.println(list);
    }
    @Test
    public void test3(){
        ArticleService articleService = (ArticleService)ac.getBean("articleServiceImpl");
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setArticleMessage("sdfsdfdsff");
        articleEntity.setArticlePageView("1");
        articleEntity.setArticleType("1");
        articleEntity.setArticleHeadPic("/static");
        articleEntity.setArticleTime("0");
        articleEntity.setArticleUserName("admin");
        articleEntity.setArticleTitle("抗压吧务团队5");
        articleEntity.setArticleID("007");
        boolean result = articleService.saveArticle(articleEntity);
        if (result){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    /**
     * 测试添加访问量
     */
    @Test
    public void test4(){
       ArticleEntity entity = new ArticleEntity();
       entity.setArticlePageView("0");
       entity.addPageView();
       entity.addPageView();
       System.out.println(entity.getArticlePageView());
    }

    /**
     * 测试注册码获取
     */
    @Test
    public void test5(){
        int num = GetUUID.yanzma();
        System.out.println(num);
        String yanzhengma = "";
        yanzhengma = String.valueOf(num);
        System.out.println(yanzhengma);
    }

    @Test
    public void test6(){
        String classpath = this.getClass().getResource("/").getPath().replaceAll("/target/test-classes/","/src/main/webapp/static/");
        System.out.println(classpath);
    }

}
