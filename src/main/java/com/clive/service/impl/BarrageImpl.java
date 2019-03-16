package com.clive.service.impl;

import com.clive.bean.Barrage;
import com.clive.mapper.BarrageMapper;
import com.clive.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarrageImpl implements BarrageService {
    @Autowired
    BarrageMapper barrageMapper;

    /**
     * 保存弹幕
     * @param barrage 弹幕对象
     */
    @Override
    public void saveBarrage(Barrage barrage) {
        barrageMapper.saveBarrage(barrage);
    }

    @Override
    public List<Barrage> selectAllBarrageByVideoId(int videoId) {

        return barrageMapper.selectAllBarrageByVideoId(videoId);
    }
}
