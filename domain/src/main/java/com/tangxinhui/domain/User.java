package com.tangxinhui.domain;

import com.tangxinhui.domain.base.BaseBean;

/**
 * 用户实体类
 * Created by xinhu on 2017/5/10.
 */
public class User extends BaseBean{
    private String ip;
    private String username;
    private String password;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
