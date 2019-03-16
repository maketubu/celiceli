package com.clive.service;

import com.clive.bean.VideoEntity;
import com.clive.bean.VideoMessageEntity;

/**
 * 有关视频服务
 */
public interface VideoService {

    // 保存视频评论
    public boolean saveMessage(VideoMessageEntity videoMessageEntity);
    //保存视频
    public boolean saveVideo(VideoEntity entity);
}
