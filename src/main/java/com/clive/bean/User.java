package com.clive.bean;

/**
 * 用户信息
 */
public class User {

    private String userID;//用户ID
    private String userRealName;//用户真实名字
    private String userName;//用户名
    private String passWord;//密码
    private String userSex;//性别
    private String userHeadPic;//头像
    private String userAddress;//地址
    private String userPhone;//手机
    private String userQQ;//qq
    private String userEmial;//邮箱
    private String userCollection;//收藏
    private String userState;//状态
    private String userLoginTime;//最后登录时间
    private String userIP;//登录IP地址
    private String userPaypassword;//支付密码
    private String userRMB;//用户余额
    private int vip; //vip
    public String getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userHeadPic='" + userHeadPic + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userEmial='" + userEmial + '\'' +
                ", userCollection='" + userCollection + '\'' +
                ", userState='" + userState + '\'' +
                ", userLoginTime='" + userLoginTime + '\'' +
                ", userIP='" + userIP + '\'' +
                ", userPaypassword='" + userPaypassword + '\'' +
                ", userRMB='" + userRMB + '\'' +
                '}';
    }

    public int getVip() { return vip; }

    public void setVip(int vip) { this.vip = vip; }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getUserEmial() {
        return userEmial;
    }

    public void setUserEmial(String userEmial) {
        this.userEmial = userEmial;
    }

    public String getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(String userCollection) {
        this.userCollection = userCollection;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(String userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getUserPaypassword() {
        return userPaypassword;
    }

    public void setUserPaypassword(String userPaypassword) {
        this.userPaypassword = userPaypassword;
    }

    public String getUserRMB() {
        return userRMB;
    }

    public void setUserRMB(String userRMB) {
        this.userRMB = userRMB;
    }
}
