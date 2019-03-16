package com.clive.mapper;

import java.util.List;

import com.clive.bean.VideoMessageEntity;
import org.apache.ibatis.annotations.Param;

public interface VideoMessageEntityMapper {
    //保存留言
    public int saveVideoReply(VideoMessageEntity videoMessageEntity);
    //根据回复id查询当前视频的所有留言
    public List<VideoMessageEntity> videoReplyListByid(String id);
}

