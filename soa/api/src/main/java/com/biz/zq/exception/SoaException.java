package com.biz.zq.exception;

public class SoaException extends Exception {
    private int code;

    public SoaException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
