package com.clive.mapper;

import com.clive.bean.Barrage;

import java.util.List;

public interface BarrageMapper {
    public void saveBarrage(Barrage barrage);
    public List<Barrage> selectAllBarrageByVideoId(int videoId);
}
