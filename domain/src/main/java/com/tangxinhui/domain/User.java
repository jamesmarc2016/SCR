package com.tangxinhui.domain;

import com.tangxinhui.domain.base.BaseBean;

/**
 * 用户实体类
 * Created by xinhu on 2017/5/10.
 */
public class User extends BaseBean{
    private String username;
    private String password;
    private String lasttime;    //最后登录时间

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
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
