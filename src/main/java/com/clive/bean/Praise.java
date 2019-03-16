package com.clive.bean;

import java.util.Date;

public class Praise {
    private int lookId;
    private String user;
    private Date creatTime;

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "lookId=" + lookId +
                ", user='" + user + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }

    public int getLookId() {
        return lookId;
    }

    public void setLookId(int lookId) {
        this.lookId = lookId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
