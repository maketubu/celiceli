package com.clive.mapper;

import com.clive.bean.ArticleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleEntityMapper {
    //保存帖子内容
    public int saveArticle(ArticleEntity article);
    //根据帖子id返回该帖子全部信息
    public ArticleEntity articleById(String id);
    //根据帖子类别返回列表
    public List<ArticleEntity> articleListByType(String type);
    //根据帖子标题返回帖子信息
    public List<ArticleEntity> articleListByTitle(String title);
    // 跟新帖子数据
    public int updatePageView(String articleId, String newView);
}

