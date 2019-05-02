package com.weidingqiang.wanbase.model.bean;

/**
 * 作者：weidingqiang on 2019-05-02 21:54
 * 邮箱：weidingqiang@163.com
 */
public class HelpVO {
    private String name;

    private String password;

    public HelpVO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
