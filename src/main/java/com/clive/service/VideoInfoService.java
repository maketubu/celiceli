package com.clive.service;

import com.clive.bean.VideoEntity;
import com.clive.bean.VideoMessageEntity;

import java.util.List;

/**
 * 有关视频信息查询的服务
 */
public interface VideoInfoService {

    //根据视频类别返回视频列表
    public List<VideoEntity> videoListByType(String type);
    //根据视频id返回视频相关留言列表
    public List<VideoMessageEntity> MessageListByVId(String id);
    //根据类别返回视频数目
    public int videoNumByType(String type);
    // 随机获取视频列表
    public List<VideoEntity> videoListRandom7MAD();  // 7条数据
    public List<VideoEntity> videoListRandom5MAD();  //5条数据
    public List<VideoEntity> videoListRandom6MAD();  //6 条数据
    public void updataVideoLookTime(String videoId);
    public int selectPraiseNum(String videiId);

    public void updataPraiseRecord(String videoID,int change);

    public int selectVideoType(String videoID);
    public int selectVip(String videoId,String userName);


}

















