package com.tangxinhui.domain.base;


import java.io.Serializable;

/**
 * base类
 * Created by xinhu on 2017/5/10.
 */
public class BaseBean implements Serializable{
    private static final long serialVersionUID = 3309571602974614374L;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
