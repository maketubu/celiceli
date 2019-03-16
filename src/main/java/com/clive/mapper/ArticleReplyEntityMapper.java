package com.clive.mapper;

import com.clive.bean.ArticleReplyEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleReplyEntityMapper {
    //保存帖子回复
    public int saveArticleReply(ArticleReplyEntity reply);
    //根据帖子的id返回该帖子的所有留言
    public List<ArticleReplyEntity> articleReplyListById(String id);


}
