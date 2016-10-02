package com.egen.UserResponse;

import com.egen.Pojo.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sateesh on 10/1/2016.
 */
/*
        UserResponse.java
        Response of the Service will be sent in this format, based on the response from server.
 */
public class UserResponse implements Serializable{
    private static final long serialVersionUID = -1798070786993154676L;

    private String description;
    private boolean success;
    private int errorCode;
    private List<User> userList;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "description='" + description + '\'' +
                ", success=" + success +
                ", errorCode=" + errorCode +
                ", userList=" + userList +
                '}';
    }
}
