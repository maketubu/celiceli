package com.clive.service;

import com.clive.bean.ArticleEntity;
import com.clive.bean.ArticleReplyEntity;

import java.util.List;

/**
 *  有关论坛帖子信息的服务
 */
public interface ArticleInfoService {
    // 根据论坛类别返回帖子列表
    public List<ArticleEntity> articleListByType(String type);
    //根据帖子id返回帖子信息
    public ArticleEntity articleById(String id);
    //根据帖子id返回回复列表
    public List<ArticleReplyEntity> ReplyByArticleId(String id);
    //根据文章标题返回帖子列表
    public List<ArticleEntity> articleListByTitle(String title);
    //
}

















