package com.tangxinhui.domain;

import com.tangxinhui.domain.base.Base;

/**
 * 用户实体类
 * Created by xinhu on 2017/5/10.
 */
public class User extends Base{
    private String name;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
