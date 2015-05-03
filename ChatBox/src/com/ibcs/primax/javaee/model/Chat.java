package com.ibcs.primax.javaee.model;

/**
 * Created by Administrator on 5/1/2015.
 */
public class Chat {
    private String userName;
    private String postTime;
    private String postSms;
    public Chat() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostSms() {
        return postSms;
    }

    public void setPostSms(String postSms) {
        this.postSms = postSms;
    }
}
