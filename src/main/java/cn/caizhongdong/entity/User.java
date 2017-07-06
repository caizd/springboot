package cn.caizhongdong.entity;

import java.io.Serializable;

/**
 * Created by caizhongdong on 2017/7/5.
 */

public class User implements Serializable {

    private static final long serialVersionUID = -5343220540016144367L;
    private String userId;
    private String name;

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }
}