package com.clive.bean;

public class Preference {
    private String userName;
    private int donghua;
    private int mad;
    private int dongman;

    @Override
    public String toString() {
        return "Preference{" +
                "userName='" + userName + '\'' +
                ", donghua=" + donghua +
                ", mad=" + mad +
                ", dongman=" + dongman +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDonghua() {
        return donghua;
    }

    public void setDonghua(int donghua) {
        this.donghua = donghua;
    }

    public int getMad() {
        return mad;
    }

    public void setMad(int mad) {
        this.mad = mad;
    }

    public int getDongman() {
        return dongman;
    }

    public void setDongman(int dongman) {
        this.dongman = dongman;
    }
}
