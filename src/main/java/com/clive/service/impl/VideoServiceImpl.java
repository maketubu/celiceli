package com.clive.service.impl;

import com.clive.bean.VideoEntity;
import com.clive.bean.VideoMessageEntity;
import com.clive.mapper.VideoEntityMapper;
import com.clive.mapper.VideoMessageEntityMapper;
import com.clive.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoEntityMapper videoEntityMapper;
    @Autowired
    VideoMessageEntityMapper videoMessageEntityMapper;
    /**
     * 保存视频回复
     * @param videoMessageEntity
     * @return
     */
    @Override
    public boolean saveMessage(VideoMessageEntity videoMessageEntity) {
        int result = videoMessageEntityMapper.saveVideoReply(videoMessageEntity);
        if  (result != 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 保存视频
     * @param entity
     * @return
     */
    @Override
    public boolean saveVideo(VideoEntity entity) {
        int result = videoEntityMapper.saveVideo(entity);
        if (result != 0){
            return true;
        }else{
            return false;
        }
    }


}
