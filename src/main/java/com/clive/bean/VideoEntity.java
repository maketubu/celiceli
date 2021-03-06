package com.clive.bean;

/**
 * 视频类
 */
public class VideoEntity {

    private String videoID; //视频ID
    private String videoName;//视频名字
    private String videoImage;//视频图片
    private String videoAddress;//视频地址
    private String videolookTime;//视频时长
    private String videoCollection;//收藏
    private String videoLeaving;//视频留言
    private String videoTime;//视频上传时间
    private String videoState;//视频状态
    private String videoType;//视频类别
    private int vip;
    private int recordOfPraise;

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getRecordOfPraise() {
        return recordOfPraise;
    }

    public void setRecordOfPraise(int recordOfPraise) {
        this.recordOfPraise = recordOfPraise;
    }


    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getVideolookTime() {
        return videolookTime;
    }

    public void setVideolookTime(String videolookTime) {
        this.videolookTime = videolookTime;
    }

    public String getVideoCollection() {
        return videoCollection;
    }

    public void setVideoCollection(String videoCollection) {
        this.videoCollection = videoCollection;
    }

    public String getVideoLeaving() {
        return videoLeaving;
    }

    public void setVideoLeaving(String videoLeaving) {
        this.videoLeaving = videoLeaving;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoState() {
        return videoState;
    }

    public void setVideoState(String videoState) {
        this.videoState = videoState;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "videoID='" + videoID + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoImage='" + videoImage + '\'' +
                ", videoAddress='" + videoAddress + '\'' +
                ", videolookTime='" + videolookTime + '\'' +
                ", videoCollection='" + videoCollection + '\'' +
                ", videoLeaving='" + videoLeaving + '\'' +
                ", videoTime='" + videoTime + '\'' +
                ", videoState='" + videoState + '\'' +
                ", videoType='" + videoType + '\'' +
                ", recordOfPraise=" + recordOfPraise +
                '}';
    }
}
