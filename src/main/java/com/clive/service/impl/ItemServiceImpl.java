package com.clive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clive.bean.Items;
import com.clive.mapper.ItemMapper;
import com.clive.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public List<Items> findItemsAll(){
        // 根据数据库访问器对象返回所有的item对象
        return itemMapper.findItemAll();
    }

    public Items findItemById(Integer id) {
        // TODO Auto-generated method stub
        return itemMapper.findItemById(id);
    }

    public void updateItems(Items item) {
        // TODO Auto-generated method stub
        itemMapper.updateItems(item);
    }


}
