package com.clive.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clive.bean.Items;
import com.clive.service.ItemService;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //返回itemlist列表信息
    @RequestMapping("/itemList")
    public ModelAndView showIndex(){
        List<Items> items = itemService.findItemsAll();
        ModelAndView modelAndView = new ModelAndView();
        // 添加属性名
        modelAndView.setViewName("itemList");
        //itemList在这里指的是/WEB-INF/jsp/itemList.jsp
        modelAndView.addObject("itemList", items);
        return modelAndView;
    }
    /**
     * 接收一个来自请求中的id
     * 根据商品id 找到商品信息
     * 这里的model使用等同于使用modelAndView，不过是返回的是一个String
     */
    @RequestMapping("/itemEdit")
    public String itemEdit(Integer id, Model model){
        Items item = itemService.findItemById(id);
        //给页面传递一个叫做item的对象
        model.addAttribute("item", item);
        return "editItem";
    }

    //更新item
    @RequestMapping("/updateitem")
    public String updateitem(Items item, HttpServletRequest request){
        itemService.updateItems(item);
        return "redirect:itemList.action";
    }

}
