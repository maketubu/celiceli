package com.clive.mapper;


import com.clive.bean.Praise;

public interface PraiseMapper {
    //查询点赞记录
    public int selectPraiseRecord(int videoId, String user);
    //删除点赞记录
    public void deletePraiseRecord(int videoId, String user);
    //插入点赞记录
    public void insertPraiseRecord(Praise praise);

}
