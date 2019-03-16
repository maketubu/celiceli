package com.clive.mapper;

import java.util.List;

import com.clive.bean.VideoEntity;
import org.apache.ibatis.annotations.Param;

public interface VideoEntityMapper {
    //根据video类别返回列表
    public List<VideoEntity> videoListByType(String type);
    //推荐算法
    //根据计算视频数
    public int videoCountByType(String type);
    // 保存视频
    public int saveVideo(VideoEntity entity);
    //随机获取视频列表
    public List<VideoEntity> videoListRandom7MAD();  // 7条数据
    public List<VideoEntity> videoListRandom5MAD();  //5条数据
    public List<VideoEntity> videoListRandom6MAD();  //6 条数据
    //    //为新来的视频，即没有浏览数的视频插入浏览记录
//    public void insertVideoLookTim(String videoId,String videoLookTime);
    //根据视频id查询浏览次数
    public int selectVideoLookTime(String videoId);
    //更新视频的浏览次数
    public void updataVideoLookTime(String videoId,int videoLookTime);
    //更加id查询视频点赞数
    public int selectPraiseNum(String videoId);

    public void updataPraiseNum(String videoID, int praiseNum);
    //查询视频类型
    public int selectVideoType(String videoID);
    public int selectVip(String videoId);


}