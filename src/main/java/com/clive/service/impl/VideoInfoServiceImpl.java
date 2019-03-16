package com.clive.service.impl;

import com.clive.bean.VideoEntity;
import com.clive.bean.VideoMessageEntity;
import com.clive.mapper.UserMapper;
import com.clive.mapper.VideoEntityMapper;
import com.clive.mapper.VideoMessageEntityMapper;
import com.clive.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInfoServiceImpl implements VideoInfoService {

    @Autowired
    VideoEntityMapper videoEntityMapper;
    @Autowired
    VideoMessageEntityMapper videoMessageEntityMapper;
    @Autowired
    UserMapper userMapper;
    /**
     * 根据类别返回视频列表
     * @param type
     * @return
     */
    @Override
    public List<VideoEntity> videoListByType(String type) {
        List<VideoEntity> list = videoEntityMapper.videoListByType(type);
        return list;
    }

    /**
     *  根据视频id返回视频回复列表
     * @param id
     * @return
     */
    @Override
    public List<VideoMessageEntity> MessageListByVId(String id) {
        List<VideoMessageEntity> list = videoMessageEntityMapper.videoReplyListByid(id);
        return list;
    }

    /**
     * 根据视频类别返回视频数目
     * @param type
     * @return
     */
    @Override
    public int videoNumByType(String type) {
        int num = videoEntityMapper.videoCountByType(type);
        return num;
    }

    /**
     * 随机获取视频列表
     */
    @Override
    public List<VideoEntity> videoListRandom7MAD() {
        List<VideoEntity> list = videoEntityMapper.videoListRandom7MAD();
        return list;
    }

    @Override
    public List<VideoEntity> videoListRandom5MAD() {
        List<VideoEntity> list = videoEntityMapper.videoListRandom5MAD();
        return list;
    }

    @Override
    public List<VideoEntity> videoListRandom6MAD() {
        List<VideoEntity> list = videoEntityMapper.videoListRandom6MAD();
        return list;
    }

    @Override
    public void updataVideoLookTime(String videoId ) {
        int videoLookTime = videoEntityMapper.selectVideoLookTime(videoId)+1;
        //int videoLookTime = videoEntityMapper.selectVideoLookTime(videoId)+1;
        System.out.println(videoLookTime);
        videoEntityMapper.updataVideoLookTime(videoId,videoLookTime);
    }

    //根据视频id查询点赞数量
    @Override
    public int selectPraiseNum(String videiId) {
        return videoEntityMapper.selectPraiseNum(videiId);

    }

    @Override
    public void updataPraiseRecord(String videoID,int change) {
        int praiseNum = videoEntityMapper.selectPraiseNum(videoID)+change;
        videoEntityMapper.updataPraiseNum(videoID,praiseNum);
    }

    /**
     * 更加视频id找出视频类型
     * @param videoID
     * @return
     */
    @Override
    public int selectVideoType(String videoID) {

        return videoEntityMapper.selectVideoType(videoID);
    }

    @Override
    public int selectVip(String videoId,String userName) {
        if(userMapper.selectUserVip(userName)==0&&videoEntityMapper.selectVip(videoId)==1) {
            return 0;
        }else {
            return 1;
        }



    }


}
