package com.clive.service;

import java.util.List;

import com.clive.bean.Items;

public interface ItemService {
    List<Items> findItemsAll();

    Items findItemById(Integer id);

    void updateItems(Items item);
}
