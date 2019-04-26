package com.weidingqiang.wanbase.model.http.response;

/**
 * 作者：weidingqiang on 2018/9/2 10:22
 * 邮箱：weidingqiang@163.com
 */

public class HttpResponseCode {

    private String message;

    private int status;

//    private String location;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
