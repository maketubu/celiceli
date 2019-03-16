package com.clive.bean;

/**
 * 视频留言类
 */
public class VideoMessageEntity {

    private String messageID; //留言ID
    private String messageVideoID;//留言视频ID
    private String messageUserID;//留言用户ID
    private String messageUserName;//留言用户名字
    private String messageContent;//留言内容
    private String messageTime;//留言时间
    private String messageHeadPic;//用户头像

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageVideoID() {
        return messageVideoID;
    }

    public void setMessageVideoID(String messageVideoID) {
        this.messageVideoID = messageVideoID;
    }

    public String getMessageUserID() {
        return messageUserID;
    }

    public void setMessageUserID(String messageUserID) {
        this.messageUserID = messageUserID;
    }

    public String getMessageUserName() {
        return messageUserName;
    }

    public void setMessageUserName(String messageUserName) {
        this.messageUserName = messageUserName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageHeadPic() {
        return messageHeadPic;
    }

    public void setMessageHeadPic(String messageHeadPic) {
        this.messageHeadPic = messageHeadPic;
    }

    @Override
    public String toString() {
        return "VideoMessageEntity{" +
                "messageID='" + messageID + '\'' +
                ", messageVideoID='" + messageVideoID + '\'' +
                ", messageUserID='" + messageUserID + '\'' +
                ", messageUserName='" + messageUserName + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageTime='" + messageTime + '\'' +
                ", messageHeadPic='" + messageHeadPic + '\'' +
                '}';
    }
}
