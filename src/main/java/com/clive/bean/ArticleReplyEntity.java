package com.clive.bean;

/**
 * 论坛帖子回复类
 */
public class ArticleReplyEntity {

    private String replyId;//回复ID
    private String replyContent;//回帖内容
    private String replyTime;//回帖时间
    private String replyHeadPic;//回帖人头像
    private String replyArticleId;//回复帖子的ID
    private String replyName;//回复人的名字

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyHeadPic() {
        return replyHeadPic;
    }

    public void setReplyHeadPic(String replyHeadPic) {
        this.replyHeadPic = replyHeadPic;
    }

    public String getReplyArticleId() {
        return replyArticleId;
    }

    public void setReplyArticleId(String replyArticleId) {
        this.replyArticleId = replyArticleId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    @Override
    public String toString() {
        return "ArticleReplyEntity{" +
                "replyId='" + replyId + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", replyHeadPic='" + replyHeadPic + '\'' +
                ", replyArticleId='" + replyArticleId + '\'' +
                ", replyName='" + replyName + '\'' +
                '}';
    }
}

