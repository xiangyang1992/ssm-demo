package com.ssm.entity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String userToken;
    /**
     * 是否已删除 0未删除 1已删除
     */
    private int isDeleted;
    private Date createTime;

    public User(Long id, String userName, String password, String userToken, int isDeleted, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userToken = userToken;
        this.isDeleted = isDeleted;
        this.createTime = createTime;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userToken='" + userToken + '\'' +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
