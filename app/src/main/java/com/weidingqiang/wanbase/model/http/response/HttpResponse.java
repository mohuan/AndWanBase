package com.weidingqiang.wanbase.model.http.response;

/**
 * 作者：weidingqiang on 2017/9/7 09:56
 * 邮箱：dqwei@iflytek.com
 */

public class HttpResponse<T> {

    private String message;
    private int status;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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
