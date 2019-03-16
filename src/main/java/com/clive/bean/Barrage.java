package com.clive.bean;

public class Barrage {
    private int videoId;//视频标识
    private String text;
    private String color;
    private Integer size;
    private Integer position;
    private Integer time;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "Barrage{" +
                "videoId=" + videoId +
                ", text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", position=" + position +
                ", time=" + time +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }


}
