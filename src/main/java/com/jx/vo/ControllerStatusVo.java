package com.jx.vo;

import com.jx.enums.ControllerEnums;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/31.
 */
public class ControllerStatusVo implements Serializable {

    private Integer code;
    private String result;
    private String message;

    public ControllerStatusVo() {
    }

    public ControllerStatusVo(Integer code,String result,String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ControllerStatusVo statusVo(ControllerEnums controllerEnums){

        return new  ControllerStatusVo(controllerEnums.getCode(),controllerEnums.getResult(),controllerEnums.getMessage());

    }
}

