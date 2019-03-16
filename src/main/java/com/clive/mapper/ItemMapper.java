package com.clive.mapper;

        import java.util.List;

        import com.clive.bean.Items;

public interface ItemMapper {
    List<Items> findItemAll();
    Items findItemById(Integer id);
    void updateItems(Items item);
}
