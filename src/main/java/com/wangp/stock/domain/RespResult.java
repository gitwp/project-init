package com.wangp.stock.domain;

import com.wangp.stock.domain.enums.ResponseEnum;

/**
 * @author 2016/5/24 wangp
 */
public class RespResult {
    private String code;
    private String msg;
    private String data;

    public RespResult() {
    }

    public RespResult(ResponseEnum res) {
        this.code = res.getCode();
        this.msg = res.getMsg();
    }

    public RespResult(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
