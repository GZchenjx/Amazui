package com.jx.enums;

/**
 * Created by Administrator on 2018/1/31.
 */
public enum  ControllerEnums {
    USER_LOGIN_SUCCESS(100, "success", "登录成功"),
    USER_LOGIN_FAIL(101, "fail", "用户名或密码错误"),
    USER_UPDATE_SUCCESS(102,"success","更新成功"),
    USER_UPDATE_FAIL(103,"fail","更新失败");
    private Integer code;
    private String result;
    private String message;

    ControllerEnums(Integer code,String result,String message) {
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
}
