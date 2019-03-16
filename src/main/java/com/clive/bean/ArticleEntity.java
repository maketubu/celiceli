package com.clive.bean;

/**
 * 论文帖子实体类
 */
// 帖子实体类
public class ArticleEntity {

    public String articleID;//文章ID
    public String articleTitle;//文章标题
    public String articleMessage;//文章内容
    public String articleUserName;//发布人名字
    public String articleTime;//发布时间
    public String articleType;//发布类别
    public String articlePageView;//帖子浏览量
    public String articleHeadPic;//头像

    // 增加帖子访问量
    public void addPageView(){
        //帖子访问量+1
        int num = Integer.valueOf(this.articlePageView);
        num = num +1;
        String newNum = String.valueOf(num);
        this.articlePageView = newNum;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleMessage() {
        return articleMessage;
    }

    public void setArticleMessage(String articleMessage) {
        this.articleMessage = articleMessage;
    }

    public String getArticleUserName() {
        return articleUserName;
    }

    public void setArticleUserName(String articleUserName) {
        this.articleUserName = articleUserName;
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticlePageView() {
        return articlePageView;
    }

    public void setArticlePageView(String articlePageView) {
        this.articlePageView = articlePageView;
    }

    public String getArticleHeadPic() {
        return articleHeadPic;
    }

    public void setArticleHeadPic(String articleHeadPic) {
        this.articleHeadPic = articleHeadPic;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "articleID='" + articleID + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleMessage='" + articleMessage + '\'' +
                ", articleUserName='" + articleUserName + '\'' +
                ", articleTime='" + articleTime + '\'' +
                ", articleType='" + articleType + '\'' +
                ", articlePageView='" + articlePageView + '\'' +
                ", articleHeadPic='" + articleHeadPic + '\'' +
                '}';
    }
}
