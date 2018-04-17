package com.biz.zq.result;

/**
 * 公共返回类
 * @author ZhengQin
 */
public class CommonResult {

    /**
     * 返回的代码
     */
    private Integer code;

    /**
     * 是否有data  讲道理  json合适
     */
    private String data;

    /**
     * 信息
     */
    private String msg;

    public CommonResult(){}

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
