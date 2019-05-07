package com.xw.zy.dubbo.one.api.response;

import com.xw.zy.dubbo.one.api.enums.StatusCode;

import java.io.Serializable;

/**
 * @author xw
 * @date 2019/5/7 9:46
 */
public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
