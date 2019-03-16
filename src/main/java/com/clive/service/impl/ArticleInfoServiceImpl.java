package com.clive.service.impl;

import com.clive.bean.ArticleEntity;
import com.clive.bean.ArticleReplyEntity;
import com.clive.mapper.ArticleEntityMapper;
import com.clive.mapper.ArticleReplyEntityMapper;
import com.clive.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService{
    @Autowired
    ArticleEntityMapper articleEntityMapper;
    @Autowired
    ArticleReplyEntityMapper articleReplyEntityMapper;

    @Override
    public List<ArticleEntity> articleListByType(String type) {
        List<ArticleEntity> list = articleEntityMapper.articleListByType(type);
        return list;
    }

    @Override
    public ArticleEntity articleById(String id) {
        ArticleEntity articleEntity = articleEntityMapper.articleById(id);
        return articleEntity;
    }
    //根据帖子id返回回复列表
    @Override
    public List<ArticleReplyEntity> ReplyByArticleId(String id) {
        List<ArticleReplyEntity> list = articleReplyEntityMapper.articleReplyListById(id);
        return list;
    }
    //根据文章标题返回帖子列表
    @Override
    public List<ArticleEntity> articleListByTitle(String title) {
        List<ArticleEntity> list = articleEntityMapper.articleListByTitle(title);
        return list;
    }
}
