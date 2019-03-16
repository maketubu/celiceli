package com.clive.service;

import com.clive.bean.ArticleEntity;
import com.clive.bean.ArticleReplyEntity;

/**
 * 帖子增删改服务
 */
public interface ArticleService {

    //保存帖子
    public boolean saveArticle(ArticleEntity article);
    // 保存回复帖子的内容
    public boolean saveArticleReply(ArticleReplyEntity articleReply);
    //删除帖子
    public boolean deleteArticleByid(String articleId);
    //删除回复
    public boolean deleteArticleReply(String articleId, String replyId);
    //跟新帖子数据
    public boolean updatePageView(String articleId, String newView);
}











