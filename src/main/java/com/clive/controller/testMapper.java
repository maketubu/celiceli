package com.clive.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clive.bean.Items;
import com.clive.service.ItemService;

public class testMapper {

    ApplicationContext ac;

    @Before
    public void initTest(){
        ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    // 测试mybatis
    @Test
    public void test1(){
        ItemService itemService = (ItemService) ac.getBean("itemServiceImpl");
        List<Items> items = itemService.findItemsAll();
        System.out.println(items);
    }
}
