package com.clive.service.impl;

import com.clive.bean.ArticleEntity;
import com.clive.bean.ArticleReplyEntity;
import com.clive.mapper.ArticleEntityMapper;
import com.clive.mapper.ArticleReplyEntityMapper;
import com.clive.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleEntityMapper articleEntityMapper;
    @Autowired
    ArticleReplyEntityMapper articleReplyEntityMapper;
    @Autowired
    ArticleInfoServiceImpl articleInfoService;

    /**
     * 保存帖子
     */
    @Override
    public boolean saveArticle(ArticleEntity article) {
        int result = articleEntityMapper.saveArticle(article);
        if (result == 0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 保存帖子回复
     * @param articleReply
     * @return
     */

    @Override
    public boolean saveArticleReply(ArticleReplyEntity articleReply) {
        int result = articleReplyEntityMapper.saveArticleReply(articleReply);
        if (result == 0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 删除帖子
     * @param articleId
     * @return
     */
    @Override
    public boolean deleteArticleByid(String articleId) {
        return false;
    }

    /**
     * 删除帖子回复
     * @param articleId
     * @param replyId
     * @return
     */
    @Override
    public boolean deleteArticleReply(String articleId, String replyId) {
        return false;
    }

    /**
     * 跟新帖子访问量
     */
    @Override
    public boolean updatePageView(String articleId, String newView) {
        int result = articleEntityMapper.updatePageView(articleId, newView);
        if (result != 0){
            return true;
        }
        else {
            return false;
        }
    }
}
