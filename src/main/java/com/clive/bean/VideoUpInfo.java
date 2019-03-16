package com.clive.bean;

public class VideoUpInfo {

    private String Filename;// 文件名字
    private long FileSize;// 文件总大小
    private long FileRemainSize;// 文件上传 剩余的
    private int UpStateTag=0;//如果大于0就是上传完成
    private int Percent=0;//百分比

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public long getFileSize() {
        return FileSize;
    }

    public void setFileSize(long fileSize) {
        FileSize = fileSize;
    }

    public long getFileRemainSize() {
        return FileRemainSize;
    }

    public void setFileRemainSize(long fileRemainSize) {
        FileRemainSize = fileRemainSize;
    }

    public int getUpStateTag() {
        return UpStateTag;
    }

    public void setUpStateTag(int upStateTag) {
        UpStateTag = upStateTag;
    }

    public int getPercent() {
        return Percent;
    }

    public void setPercent(int percent) {
        Percent = percent;
    }

    @Override
    public String toString() {
        return "VideoUpInfo{" +
                "Filename='" + Filename + '\'' +
                ", FileSize=" + FileSize +
                ", FileRemainSize=" + FileRemainSize +
                ", UpStateTag=" + UpStateTag +
                ", Percent=" + Percent +
                '}';
    }
}
