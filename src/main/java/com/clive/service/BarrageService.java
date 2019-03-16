package com.clive.service;

import com.clive.bean.Barrage;

import java.util.List;

public interface BarrageService {
    //保存弹幕
    public void saveBarrage(Barrage barrage);
    //根据id查询所有弹幕
    public List<Barrage> selectAllBarrageByVideoId(int videoId);
}
